package ATMSimulationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JLabel accountDetails,type,card,number,pin,pin_number,cardDetails,pinDetails,services;
    JRadioButton savingButton,fixedDepositButton,currentButton,dematButton;
    JCheckBox atmcard,internetBanking,mobileBanking,email_sms,chequeBook,eStatement,declaration;
    JButton submit,cancel;
    String formno;
    
    SignUpThree(String formno){
        this.formno = formno;
        getContentPane().setBackground(Color.WHITE);
        
        accountDetails = new JLabel("Account Details - Page 3");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
        accountDetails.setBounds(280,40,400,40);
        add(accountDetails);
        
        type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        savingButton = new JRadioButton("Savings Account");
        savingButton.setFont(new Font("Raleway",Font.BOLD,16));
        savingButton.setBackground(Color.WHITE);
        savingButton.setBounds(100,180,250,20);
        add(savingButton);
        
        fixedDepositButton = new JRadioButton("Fixed Deposit Account");
        fixedDepositButton.setFont(new Font("Raleway",Font.BOLD,16));
        fixedDepositButton.setBackground(Color.WHITE);
        fixedDepositButton.setBounds(350,180,250,20);
        add(fixedDepositButton);
        
        currentButton = new JRadioButton("Current Account");
        currentButton.setFont(new Font("Raleway",Font.BOLD,16));
        currentButton.setBackground(Color.WHITE);
        currentButton.setBounds(100,220,250,20);
        add(currentButton);
        
        dematButton = new JRadioButton("DeMat Account");
        dematButton.setFont(new Font("Raleway",Font.BOLD,16));
        dematButton.setBackground(Color.WHITE);
        dematButton.setBounds(350,220,250,20);
        add(dematButton);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(savingButton);
        groupaccount.add(fixedDepositButton);
        groupaccount.add(currentButton);
        groupaccount.add(dematButton);
        
        
        card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        number = new JLabel("XXXX-XXXX-XXXX-2106");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        cardDetails = new JLabel("This is your 16 Digit Card Number ");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);
        
        
        pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);
        
        pin_number = new JLabel("XXXX ");
        pin_number.setFont(new Font("Raleway",Font.BOLD,22));
        pin_number.setBounds(330,370,300,30);
        add(pin_number);
        
        pinDetails = new JLabel("This is your 4 Digit PIN ");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);
        
        services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);
        
        atmcard = new JCheckBox("ATM Card");
        atmcard.setBackground(Color.WHITE);
        atmcard.setFont(new Font("Raleway",Font.BOLD,16));
        atmcard.setBounds(100,500,200,30);
        add(atmcard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway",Font.BOLD,16));
        internetBanking.setBounds(350,500,200,30);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,16));
        mobileBanking.setBounds(100,550,200,30);
        add(mobileBanking);
        
        email_sms = new JCheckBox("EMAIL & SMS alerts");
        email_sms.setBackground(Color.WHITE);
        email_sms.setFont(new Font("Raleway",Font.BOLD,16));
        email_sms.setBounds(350,550,200,30);
        add(email_sms);
        
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway",Font.BOLD,16));
        chequeBook.setBounds(100,600,200,30);
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway",Font.BOLD,16));
        eStatement.setBounds(350,600,200,30);
        add(eStatement);
        
        declaration = new JCheckBox("I, Hereby declare that all the details given above are correct and best to my knowledge.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway",Font.BOLD,12));
        declaration.setBounds(100,680,800,30);
        add(declaration);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(250,750,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(450,750,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        setLayout(null);
        setSize(850,820);
        setLocation(350,0); //to open the frame in the middle of the screen
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            String accountType = null;
            if(savingButton.isSelected()){
                accountType = "Savings Account";
            }else if(fixedDepositButton.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(currentButton.isSelected()){
                accountType = "Current Account";
            }else if(dematButton.isSelected()){
                accountType = "Demat Account";
            }
           
            
            Random ran = new Random();
            String cardnum = "" + Math.abs((ran.nextLong() % 90000000L ) + 5085008500000000L);
            String pinnumber = ""  + Math.abs((ran.nextLong() % 9000L) + 1002L);
            
            String facilities = " ";
            if(atmcard.isSelected()){
                facilities = facilities + "ATM Card ";
            }if(internetBanking.isSelected()){
                facilities = facilities + "Internet Banking ";
            }if(mobileBanking.isSelected()){
                facilities = facilities + "Mobile Banking ";
            }if(email_sms.isSelected()){
                facilities = facilities + "Email & SMS alerts ";
            }if(chequeBook.isSelected()){
                facilities = facilities + "Cheque Book ";
            }if(eStatement.isSelected()){
                facilities = facilities + "E-Statement ";
            }
            
            
            
            try{
                if(type.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Mandatory!!");
                }
                if(services.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Select atleast 1 Service!!");
                }
                if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null, "Please Check the declaration");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnum+"','"+pinnumber+"','"+facilities+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnum+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Your Card Number is: "+cardnum+ "\nPin is: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new SignUpThree("");
    }
}
