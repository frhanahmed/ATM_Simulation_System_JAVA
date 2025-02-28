package ATMSimulationSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JLabel image,text,pintext,repintext;
    JPasswordField pinTextField,repinTextField;
    JButton changeButton,backButton;
    String pinnumber;
    
    PinChange(String pinnumber){  
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN ");
        text.setForeground(Color.CYAN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        
        pintext = new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pinTextField = new JPasswordField();
        pinTextField.setBackground(Color.WHITE);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        pinTextField.setBounds(330,320,180,25);
        image.add(pinTextField);
        
        
        repintext = new JLabel("Re-Enter New PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repinTextField = new JPasswordField();
        repinTextField.setBackground(Color.WHITE);
        repinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        repinTextField.setBounds(330,360,180,25);
        image.add(repinTextField);
        
        changeButton = new JButton("CHANGE");
        changeButton.setBounds(355,485,150,30);
        changeButton.addActionListener(this);
        image.add(changeButton);
        
        
        backButton = new JButton("BACK");
        backButton.setBounds(355,520,150,30);
        backButton.addActionListener(this);
        image.add(backButton);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true); //opens the window in the entire screen removing the upper bar..
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == changeButton){
            try{
                String pin_value = pinTextField.getText();
                String repin_value = repinTextField.getText();
                
                
                 if(pin_value.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN! ");
                    return;
                }
                if(repin_value.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN! ");
                    return;
                }
            
                if(!pin_value.equals(repin_value)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does NOT match!!");
                    return;
                }else{
                    Conn conn = new Conn();
                    String query1 = "update bank set Pin = '"+repin_value+"' where Pin = '"+pinnumber+"'";
                    String query2 = "update login set Pin_No = '"+repin_value+"' where Pin_No = '"+pinnumber+"'";
                    String query3 = "update signupthree set Pin_No = '"+repin_value+"' where Pin_No = '"+pinnumber+"'";
                
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                
                    JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY!!");
                    setVisible(false);
                    new Transactions(repin_value).setVisible(true);
                }

            }catch(Exception e){
                    System.out.println(e.getMessage());
                }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
