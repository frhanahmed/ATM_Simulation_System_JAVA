package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JLabel image,text;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balancecheck,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.CYAN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(210,300,700,35);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(175, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(175, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(175, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancecheck = new JButton("Balance Enquiry");
        balancecheck.setBounds(355, 485, 150, 30);
        balancecheck.addActionListener(this);
        image.add(balancecheck);

        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true); //opens the window in the entire screen removing the upper bar..
        setVisible(true); // better to write always at the end..
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balancecheck){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("");
    }
}
