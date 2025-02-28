package ATMSimulationSystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener{
    
    JLabel formno, personaldetails, name,fname,dob,gender,email,marital,address,city,state,pincode;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton maleButton,femaleButton,marriedButton,unmarriedButton,otherButton;
    JButton nextButton;

    JDateChooser dateChooser;
    
    Random rand = new Random();
    long random = Math.abs((rand.nextLong() % 9000L )+ 1000L);
    
    
    SignUpOne(){
        
        

        getContentPane().setBackground(Color.WHITE); 
        
        

        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        personaldetails = new JLabel("Page 1 : Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290 , 80, 400, 30);
        add(personaldetails);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100 , 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(nameTextField);


        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100 , 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(fnameTextField);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100 , 240, 200, 30);
        add(dob);
        
        
        dateChooser = new JDateChooser();
        //dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100 , 290, 200, 30);
        add(gender);

        maleButton = new JRadioButton("Male");
        maleButton.setFont(new Font("Raleway", Font.BOLD, 14));
        maleButton.setBackground(Color.WHITE);
        maleButton.setBounds(300,290,60,30);
        add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setFont(new Font("Raleway", Font.BOLD, 14));
        femaleButton.setBackground(Color.WHITE);
        femaleButton.setBounds(450,290,90,30);
        add(femaleButton);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(maleButton);
        groupgender.add(femaleButton);
        

        email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100 , 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100 , 390, 200, 30);
        add(marital);


        marriedButton = new JRadioButton("Married");
        marriedButton.setFont(new Font("Raleway", Font.BOLD, 14));
        marriedButton.setBackground(Color.WHITE);
        marriedButton.setBounds(300,390,100,30);
        add(marriedButton);
        
        unmarriedButton = new JRadioButton("Unmarried");
        unmarriedButton.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarriedButton.setBackground(Color.WHITE);
        unmarriedButton.setBounds(450,390,100,30);
        add(unmarriedButton);
        
        otherButton = new JRadioButton("Other");
        otherButton.setFont(new Font("Raleway", Font.BOLD, 14));
        otherButton.setBackground(Color.WHITE);
        otherButton.setBounds(635,390,100,30);
        add(otherButton);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(marriedButton);
        groupstatus.add(unmarriedButton);
        groupstatus.add(otherButton);


        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100 , 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100 , 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100 , 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100 , 590, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);


        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Raleway", Font.BOLD, 14));
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);

        nextButton.setBounds(620,660,80,30);
        nextButton.addActionListener(this);
        add(nextButton);
        
        
        setLayout(null);
        setSize(850,800);
        setLocation(500,120); //to open the frame in the middle of the screen
        setVisible(true); // to make the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = " " + random;
        String name = nameTextField.getText(); // to get the text from TextField
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(maleButton.isSelected()){
            gender = "Male";
        }else if(femaleButton.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        
        String marital = null;
        if(marriedButton.isSelected()){
            marital = "Married";
        }else if(unmarriedButton.isSelected()){
            marital = "Unmarried";
        }else if(otherButton.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required!!!");
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required!!!");
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required!!!");
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required!!!");
            }else{
                Conn c = new Conn();
                String query = " insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new SignUpOne();
    }
}

