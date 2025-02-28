package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;  // for ResultSet
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel image,text;
    JButton oneHundred,fiveHundred,oneThousand,twoThousand,fiveThousand,tenThousand,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Select Withdrawl Amount ");
        text.setForeground(Color.CYAN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(210,300,700,35);
        image.add(text);
        
        oneHundred = new JButton("Rs 100");
        oneHundred.setBounds(175, 415, 150, 30);
        oneHundred.addActionListener(this);
        image.add(oneHundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355, 415, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        oneThousand = new JButton("rs 1,000");
        oneThousand.setBounds(175, 450, 150, 30);
        oneThousand.addActionListener(this);
        image.add(oneThousand);
        
        twoThousand = new JButton("Rs 2,000");
        twoThousand.setBounds(355, 450, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5,000");
        fiveThousand.setBounds(175, 485, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10,000");
        tenThousand.setBounds(355, 485, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true); //opens the window in the entire screen removing the upper bar..
        setVisible(true); // better to write always at the end..
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where Pin = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("Amount")) ;
                    }else{
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Sorry, Insufficient Balance!");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited Successfully!!");
                
                setVisible(false);
                new Transactions(pinnumber);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void main(String[] args){
        new FastCash("");
    }
}
