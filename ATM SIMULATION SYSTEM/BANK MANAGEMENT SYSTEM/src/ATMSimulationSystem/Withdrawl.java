package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JLabel image,text;
    JTextField amountWithdraw;
    JButton withdrawButton,withdrawBackButton;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Enter the amount you want to Withdraw: ");
        text.setFont(new Font("System", Font.BOLD ,16));
        text.setForeground(Color.CYAN);
        text.setBounds(170 ,300,400,20);
        image.add(text);
        
        amountWithdraw = new JTextField();
        amountWithdraw.setFont(new Font("Raleway",Font.BOLD,22));
        amountWithdraw.setBounds(170,350,320,25);
        image.add(amountWithdraw);
        
        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(355,485,150,30);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);
        
        withdrawBackButton = new JButton("BACK");
        withdrawBackButton.setBounds(355,520,150,30);
        withdrawBackButton.addActionListener(this);
        image.add(withdrawBackButton);
        
        
        
        setLocation(300,0);
        setSize(900,900);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawButton){
            String money = amountWithdraw.getText();
            Date date = new Date();
            
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Some Amount To Withdraw!!");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+money+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+money+ " Withdraw Successfully!!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }
        }else if(ae.getSource() == withdrawBackButton){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}
