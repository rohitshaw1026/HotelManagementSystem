package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener{
    JTextField nameTextField,ageTextField,carCompanyTextField,carModelTextField,locationTextField;
    JComboBox<String> genderChoice,availableTypeChoice;
    JButton addDriver,cancel;

    AddDriver(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,600,400);
        add(image);

        JLabel label =new JLabel("Add Driver");
        label.setBounds(120,20,150,30);
        label.setFont(new Font("System",Font.BOLD,22));
        add(label);

        JLabel name =new JLabel("Name");
        name.setBounds(30,70,170,30);
        name.setFont(new Font("System",Font.BOLD,20));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(200,70,160,30);
        nameTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(nameTextField);

        JLabel age =new JLabel("Age");
        age.setBounds(30,125,170,30);
        age.setFont(new Font("System",Font.BOLD,20));
        add(age);

        ageTextField=new JTextField();
        ageTextField.setBounds(200,125,160,30);
        ageTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(ageTextField);

        JLabel gender =new JLabel("Gender");
        gender.setBounds(30,180,170,30);
        gender.setFont(new Font("System",Font.BOLD,20));
        add(gender);

        String [] genderValues ={"Male","Female"};
        genderChoice=new JComboBox<>(genderValues); // adding a dropdown box with multiple options to choose
        genderChoice.setBounds(200,180,160,30);
        genderChoice.setFont(new Font("System",Font.BOLD,20));
        genderChoice.setBackground(Color.WHITE);
        add(genderChoice);

        JLabel carCompany =new JLabel("Car Company");
        carCompany.setBounds(30,235,170,30);
        carCompany.setFont(new Font("System",Font.BOLD,20));
        add(carCompany);

        carCompanyTextField=new JTextField();
        carCompanyTextField.setBounds(200,235,160,30);
        carCompanyTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(carCompanyTextField);

        JLabel carModel =new JLabel("Car Model");
        carModel.setBounds(30,290,170,30);
        carModel.setFont(new Font("System",Font.BOLD,20));
        add(carModel);

        carModelTextField=new JTextField();
        carModelTextField.setBounds(200,290,160,30);
        carModelTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(carModelTextField);

        JLabel available =new JLabel("Available");
        available.setBounds(30,345,170,30);
        available.setFont(new Font("System",Font.BOLD,20));
        add(available);

        String [] availableValues ={"Available","Not Available"};
        availableTypeChoice=new JComboBox<>(availableValues); // adding a dropdown box with multiple options to choose
        availableTypeChoice.setBounds(200,340,160,30);
        availableTypeChoice.setFont(new Font("System",Font.BOLD,20));
        availableTypeChoice.setBackground(Color.WHITE);
        add(availableTypeChoice);

        JLabel location =new JLabel("Location");
        location.setBounds(30,395,170,30);
        location.setFont(new Font("System",Font.BOLD,20));
        add(location);

        locationTextField=new JTextField();
        locationTextField.setBounds(200,395,160,30);
        locationTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(locationTextField);

        addDriver=new JButton("Add Driver");
        addDriver.setBounds(30,460,150,30);
        addDriver.setFont(new Font("System",Font.PLAIN,18));
        addDriver.setForeground(Color.white);
        addDriver.setBackground(Color.BLACK);
        addDriver.addActionListener(this);
        add(addDriver);

        cancel =new JButton("Cancel");
        cancel.setBounds(200,460,160,30);
        cancel.setFont(new Font("System",Font.PLAIN,18));
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
        setSize(1050,550);
        setLocation(250,140);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
        }else if(ae.getSource()==addDriver){
            String name=nameTextField.getText();
            String age=ageTextField.getText();
            String gender=(String)genderChoice.getSelectedItem();
            String carCompany=carCompanyTextField.getText();
            String carModel=carModelTextField.getText();
            String available=(String)availableTypeChoice.getSelectedItem();
            String location=locationTextField.getText();

            try{
                Conn c=new Conn();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carModel+"','"+available+"','"+location+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Driver added successfully");

                setVisible(false);


            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}


