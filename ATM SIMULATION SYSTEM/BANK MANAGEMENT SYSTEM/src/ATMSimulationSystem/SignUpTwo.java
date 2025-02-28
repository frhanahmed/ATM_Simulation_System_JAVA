package ATMSimulationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    JLabel additionalDetails, religion,category,income,education,qualification,occupation,pan,aadhaar,seniorCitizen,existingAccount;
    JTextField panTextField,aadhaarTextField;
    JRadioButton yesButton,noButton,yesExistingButton,notExistingButton;
    JButton nextButton;
    String formno;

    
    
    
    SignUpTwo(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        getContentPane().setBackground(Color.WHITE); 

        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290 , 80, 400, 30);
        add(additionalDetails);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100 , 140, 200, 30);
        add(religion);
        
        String valReligion[] = {"Muslim","Hindu","Sikh","Christian","Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100 , 190, 200, 30);
        add(category);
        
        
        String valCategory[] = {"General","SC","OBC-A","ST","Other"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setFont(new Font("Raleway",Font.BOLD,14));
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100 , 240, 200, 30);
        add(income);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto !0,00,000"};
        incomeBox = new JComboBox(incomeCategory);
        incomeBox.setFont(new Font("Raleway",Font.BOLD,14));
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        

        education = new JLabel("Educational: ");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100 , 290, 200, 30);
        add(education);
       
        
        qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100 , 315, 200, 30);
        add(qualification);
        
        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctorate","Others"};
        educationBox = new JComboBox(educationValues);
        educationBox.setFont(new Font("Raleway",Font.BOLD,14));
        educationBox.setBounds(300,315,400,30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);


        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100 , 390, 200, 30);
        add(occupation);
        
        String occupationValues[] = {"Student","Business-Man","Salaried","Self-Employeed","Retired"};
        occupationBox = new JComboBox(occupationValues);
        occupationBox.setFont(new Font("Raleway",Font.BOLD,14));
        occupationBox.setBounds(300,390,400,30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);


        pan = new JLabel("Pan No: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100 , 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        aadhaar = new JLabel("Aadhaar No: ");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhaar.setBounds(100 , 490, 200, 30);
        add(aadhaar);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadhaarTextField.setBounds(300,490,400,30);
        add(aadhaarTextField);

        seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizen.setBounds(100 , 540, 200, 30);
        add(seniorCitizen);
        
        
        yesButton = new JRadioButton("Yes");
        yesButton.setFont(new Font("Raleway", Font.BOLD, 14));
        yesButton.setBackground(Color.WHITE);
        yesButton.setBounds(300,540,100,30);
        add(yesButton);
        
        noButton = new JRadioButton("No");
        noButton.setFont(new Font("Raleway", Font.BOLD, 14));
        noButton.setBackground(Color.WHITE);
        noButton.setBounds(450,540,100,30);
        add(noButton);
        
        ButtonGroup seniorstatus = new ButtonGroup();
        seniorstatus.add(yesButton);
        seniorstatus.add(noButton);

        existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccount.setBounds(100 , 590, 200, 30);
        add(existingAccount);
        
        yesExistingButton = new JRadioButton("Yes");
        yesExistingButton.setFont(new Font("Raleway", Font.BOLD, 14));
        yesExistingButton.setBackground(Color.WHITE);
        yesExistingButton.setBounds(300,590,100,30);
        add(yesExistingButton);
        
        notExistingButton = new JRadioButton("No");
        notExistingButton.setFont(new Font("Raleway", Font.BOLD, 14));
        notExistingButton.setBackground(Color.WHITE);
        notExistingButton.setBounds(450,590,100,30);
        add(notExistingButton);
        
        ButtonGroup existstatus = new ButtonGroup();
        existstatus.add(yesExistingButton);
        existstatus.add(notExistingButton);
        

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
        String religion_name = (String)religionBox.getSelectedItem(); // to get the text from ComboBox
        String category_name  = (String)categoryBox.getSelectedItem();
        String income_value = (String) incomeBox.getSelectedItem();
        String education_value = (String) educationBox.getSelectedItem();
        String occupation_value = (String) occupationBox.getSelectedItem();
        String senior_value = null;
        if(yesButton.isSelected()){
            senior_value = "Yes";
        }else if(noButton.isSelected()){
            senior_value = "No";
        }
        
        String existing_value = null;
        if(yesExistingButton.isSelected()){
            existing_value = "Yes";
        }else if(notExistingButton.isSelected()){
            existing_value = "No";
        }
        
        
        String pan_value = panTextField.getText();
        String aadhaar_value = aadhaarTextField.getText();
        
        
        try{
            if(pan_value.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Number is Required!!!");
            }
            if(aadhaar_value.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhaar Number is Required!!!");
            }else{
                Conn c = new Conn();
                String query = " insert into signuptwo values('"+formno+"','"+religion_name+"','"+category_name+"','"+income_value+"','"+education_value+"','"+occupation_value+"','"+senior_value+"','"+existing_value+"','"+pan_value+"','"+aadhaar_value+"')";
                c.s.executeUpdate(query);
                
                //SignUp3 Object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
