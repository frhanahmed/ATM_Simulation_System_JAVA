package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel image,finalAmount;
    JButton backButton;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber= pinnumber;
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        backButton = new JButton("BACK");
        backButton.setBounds(355,520,150,30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where Pin = '"+pinnumber+"' ");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance +=Integer.parseInt(rs.getString("Amount")) ;
                }else{
                    balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
            }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
            
        
            finalAmount = new JLabel("Your Account Balanace is: Rs " +balance);
            finalAmount.setForeground(Color.WHITE);
            finalAmount.setBounds(170,300,400,30);
            image.add(finalAmount);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true); //opens the window in the entire screen removing the upper bar..
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
