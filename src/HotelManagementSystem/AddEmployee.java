package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{

    JTextField nameTextField,ageTextField,salaryTextField,phoneTextField,emailTextField,aadhaarTextField;
    JRadioButton male,female;
    JComboBox<String> JobRoleChoice;
    JButton submit;
    AddEmployee(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,120,600,400);
        add(image);

        JLabel name=new JLabel("Name");
        name.setBounds(50,30,110,30);
        name.setFont(new Font("System",Font.BOLD,25));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(180,30,220,30);
        nameTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(nameTextField);

        JLabel age =new JLabel("Age");
        age.setBounds(50,100,110,30);
        age.setFont(new Font("System",Font.BOLD,25));
        add(age);

        ageTextField =new JTextField();
        ageTextField.setBounds(180,100,220,30);
        ageTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(ageTextField);

        JLabel gender =new JLabel("Gender");
        gender.setBounds(50,170,110,30);
        gender.setFont(new Font("System",Font.BOLD,25));
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(180,170,100,30);
        male.setFont(new Font("System",Font.BOLD,20));
        male.setBackground(Color.white);
        add(male);

        female =new JRadioButton("Female");
        female.setBounds(300,170,120,30);
        female.setFont(new Font("System",Font.BOLD,20));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup= new ButtonGroup(); // using ButtonGroup so that either male or female is selected at a time
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel jobRole =new JLabel("Job Role");
        jobRole.setBounds(50,240,110,30);
        jobRole.setFont(new Font("System",Font.BOLD,25));
        add(jobRole);

        String [] JobRoleValues ={"Front Desk Clerk","Porter","Housekeeping","Kitchen Staff","Room Service","Chef","Waiter","Manager","Accountant"};
        JobRoleChoice=new JComboBox<>(JobRoleValues); // adding a dropdown box with multiple options to choose
        JobRoleChoice.setBounds(180,240,220,30);
        JobRoleChoice.setFont(new Font("System",Font.BOLD,20));
        JobRoleChoice.setBackground(Color.WHITE);
        add(JobRoleChoice);

        JLabel salary =new JLabel("Salary");
        salary.setBounds(50,310,110,30);
        salary.setFont(new Font("System",Font.BOLD,25));
        add(salary);

        salaryTextField =new JTextField();
        salaryTextField.setBounds(180,310,220,30);
        salaryTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(salaryTextField);

        JLabel phone =new JLabel("Phone");
        phone.setBounds(50,370,110,30);
        phone.setFont(new Font("System",Font.BOLD,25));
        add(phone);

        phoneTextField=new JTextField();
        phoneTextField.setBounds(180,370,220,30);
        phoneTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(phoneTextField);

        JLabel email =new JLabel("Email");
        email.setBounds(50,440,110,30);
        email.setFont(new Font("System",Font.BOLD,25));
        add(email);

        emailTextField =new JTextField();
        emailTextField.setBounds(180,440,220,30);
        emailTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(emailTextField);

        JLabel aadhaar =new JLabel("Aadhaar");
        aadhaar.setBounds(50,510,110,30);
        aadhaar.setFont(new Font("System",Font.BOLD,25));
        add(aadhaar);

        aadhaarTextField =new JTextField();
        aadhaarTextField.setBounds(180,510,220,30);
        aadhaarTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(aadhaarTextField);

        submit=new JButton("Submit");
        submit.setBounds(180,570,220,35);
        submit.setFont(new Font("System",Font.BOLD,30));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);


        setSize(1000,700);
        setLocation(280,135);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=nameTextField.getText();
        String age=ageTextField.getText();
        String gender="";
        if(male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";
        }
        String jobRole=(String)JobRoleChoice.getSelectedItem();
        String salary=salaryTextField.getText();
        String phone=phoneTextField.getText();
        String email=emailTextField.getText();
        String aadhaar=aadhaarTextField.getText();

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Name is required");
            return;
        }else if(age.isEmpty()){
            JOptionPane.showMessageDialog(null,"Age is required");
            return;
        }else if(gender.isEmpty()){
            JOptionPane.showMessageDialog(null,"Gender is required");
            return;
        }else if(salary.isEmpty()){
            JOptionPane.showMessageDialog(null,"Salary is required");
            return;
        }else if(phone.isEmpty()){
            JOptionPane.showMessageDialog(null,"Phone is required");
            return;
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(null,"Email is required");
            return;
        }else if(aadhaar.isEmpty()){
            JOptionPane.showMessageDialog(null,"Aadhaar is required");
            return;
        }

        try{
            Conn c=new Conn();
            String query="insert into employee values ('"+name+"','"+age+"','"+gender+"','"+jobRole+"','"+salary+"','"+phone+"','"+email+"','"+aadhaar+"')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
