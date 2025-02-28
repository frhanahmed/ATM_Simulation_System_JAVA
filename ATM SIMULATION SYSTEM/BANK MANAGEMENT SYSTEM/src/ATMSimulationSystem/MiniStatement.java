package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    JLabel bank,card,mini;
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber= pinnumber;
        
        mini = new JLabel();
        add(mini);
        
        bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs =conn.s.executeQuery("select * from login where Pin_No = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " +rs.getString("Card_No").substring(0, 4) + "XXXXXXXX" +rs.getString("Card_No").substring(12) );
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            Conn conn = new Conn();
            ResultSet rs =conn.s.executeQuery("select * from bank where Pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"  + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br> <html>");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        mini.setBounds(20,140,400,200);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(20,20);
        setSize(400,600);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
