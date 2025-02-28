package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JLabel image,text;
    JTextField amountDeposit;
    JButton depositButton,depositBackButton;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Enter the amount you want to Deposit: ");
        text.setFont(new Font("System", Font.BOLD ,16));
        text.setForeground(Color.CYAN);
        text.setBounds(170 ,300,400,20);
        image.add(text);
        
        amountDeposit = new JTextField();
        amountDeposit.setFont(new Font("Raleway",Font.BOLD,22));
        amountDeposit.setBounds(170,350,320,25);
        image.add(amountDeposit);
        
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(355,485,150,30);
        depositButton.addActionListener(this);
        image.add(depositButton);
        
        depositBackButton = new JButton("BACK");
        depositBackButton.setBounds(355,520,150,30);
        depositBackButton.addActionListener(this);
        image.add(depositBackButton);
        
        
        
        setLocation(300,0);
        setSize(900,900);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == depositButton){
            String money = amountDeposit.getText();
            Date date = new Date();
            
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Some Amount To Deposited!!");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+money+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+money+ " Deposited Successfully!!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }
        }else if(ae.getSource() == depositBackButton){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Deposit("");
    }
}
