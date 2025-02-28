package ATMSimulationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  // for ResultSet

public class Login extends JFrame implements ActionListener{

    JButton signin,clear,signup;
    JTextField cardtext;
    JPasswordField pintext;
    Login(){
        setTitle("ATM SIMULATION SYSTEM"); //heading of the frame

        setLayout(null); // turning off the default layout

        ImageIcon icon = new ImageIcon("icons/logo.jpg"); // bringing the image
        Image icon1 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //resizing the image
        ImageIcon icon2 = new ImageIcon(icon1);
        JLabel label = new JLabel(icon2);  // creating instance to be added in the frame
        label.setBounds(70, 10, 100, 100); // to set the label
        add(label); // adding the image in the frame..

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        //Card Number
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardtext = new JTextField();
        cardtext.setBounds(300,150,230,30);
        cardtext.setFont(new Font("Arial", Font.BOLD,14));
        add(cardtext);


        //Pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        
        add(pin);

        pintext = new JPasswordField();
        pintext.setBounds(300,220,230,30);
        pintext.setFont(new Font("Arial", Font.BOLD,14));
        add(pintext);

        //Creation of butons
        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);


        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        
        setSize(800, 480); // defining the size of the frame
        setVisible(true); // to make the frame visible
        setLocation(350, 200); //to open the frame in the middle of the screen
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardtext.setText("");
            pintext.setText("");
        } else if (ae.getSource() == signin){
            
                Conn conn = new Conn();
                String cardnumber = cardtext.getText();
                String pinnumber = pintext.getText();
                
                String query = "select * from login where Card_No = '"+cardnumber+"'and Pin_No = '"+pinnumber+"'";
                
                
                try{
                    ResultSet rs = conn.s.executeQuery(query);
                    
                    if(rs.next()){ // means the user has successfully logged in
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Credintials!!\nCheck Your Card Number or Pin."); //USed to PopUp a Message
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
        } else if (ae.getSource() == signup){
            setVisible(false); //to close the current window
            new SignUpOne().setVisible(true); // to open this window
        }
    }
        public static void main(String[] args) {
            new Login();
        }
}