package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class NewCustomerForm extends JFrame implements ActionListener{

    JComboBox<String> idChoice;
    JTextField nameTextField,idNoTextField,countryTextField,depositTextField;
    JRadioButton male,female;
    JButton addCustomer,back;
    Choice allocatedRoom;
    JLabel checkInTimeLabel;

    NewCustomerForm(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(380,370,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,50,380,400);
        add(image);

        JLabel label=new JLabel("New Customer Form");
        label.setBounds(80,20,250,30);
        label.setFont(new Font("System",Font.PLAIN,24));
        label.setForeground(Color.blue);
        add(label);

        JLabel id=new JLabel("ID");
        id.setBounds(20,70,190,30);
        id.setFont(new Font("System",Font.BOLD,20));
        add(id);

        String [] idValues ={"Aadhaar Card","Pan Card","Passport","Driving License"};
        idChoice=new JComboBox<>(idValues); // adding a dropdown box with multiple options to choose
        idChoice.setBounds(220,70,180,30);
        idChoice.setFont(new Font("System",Font.BOLD,18));
        idChoice.setBackground(Color.WHITE);
        add(idChoice);

        JLabel idNo =new JLabel("Number");
        idNo.setBounds(20,120,190,30);
        idNo.setFont(new Font("System",Font.BOLD,20));
        add(idNo);

        idNoTextField=new JTextField();
        idNoTextField.setBounds(220,120,180,30);
        idNoTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(idNoTextField);

        JLabel name =new JLabel("Name");
        name.setBounds(20,170,190,30);
        name.setFont(new Font("System",Font.BOLD,20));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(220,170,180,30);
        nameTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(nameTextField);

        JLabel gender =new JLabel("Gender");
        gender.setBounds(20,220,190,30);
        gender.setFont(new Font("System",Font.BOLD,20));
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(220,220,90,30);
        male.setFont(new Font("System",Font.BOLD,18));
        male.setBackground(Color.white);
        add(male);

        female =new JRadioButton("Female");
        female.setBounds(310,220,90,30);
        female.setFont(new Font("System",Font.BOLD,18));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup= new ButtonGroup(); // using ButtonGroup so that either male or female is selected at a time
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel country =new JLabel("Country");
        country.setBounds(20,270,190,30);
        country.setFont(new Font("System",Font.BOLD,20));
        add(country);

        countryTextField=new JTextField();
        countryTextField.setBounds(220,270,180,30);
        countryTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(countryTextField);

        JLabel allocatedRoomNo =new JLabel("Allocated Room No");
        allocatedRoomNo.setBounds(20,320,190,30);
        allocatedRoomNo.setFont(new Font("System",Font.BOLD,20));
        add(allocatedRoomNo);

        allocatedRoom=new Choice();
        try{
            Conn c=new Conn();
            String query="select * from room where availabilityStatus='Available'";

            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                allocatedRoom.add(rs.getString("roomNo"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        allocatedRoom.setBounds(220,320,180,30);
        allocatedRoom.setFont(new Font("Ariel",Font.PLAIN,18));
        add(allocatedRoom);

        JLabel checkInTime =new JLabel("Check-In Time");
        checkInTime.setBounds(20,370,190,30);
        checkInTime.setFont(new Font("System",Font.BOLD,20));
        add(checkInTime);

        Date date=new Date();

        checkInTimeLabel=new JLabel(""+date);
        checkInTimeLabel.setBounds(220,370,190,30);
        checkInTimeLabel.setFont(new Font("System",Font.BOLD,16));
        add(checkInTimeLabel);

        JLabel deposit =new JLabel("Deposit");
        deposit.setBounds(20,420,190,30);
        deposit.setFont(new Font("System",Font.BOLD,20));
        add(deposit);

        depositTextField=new JTextField();
        depositTextField.setBounds(220,420,180,30);
        depositTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(depositTextField);


        addCustomer=new JButton("Add Customer");
        addCustomer.setBounds(10,470,200,30);
        addCustomer.setForeground(Color.white);
        addCustomer.setBackground(Color.BLACK);
        addCustomer.addActionListener(this);
        add(addCustomer);

        back=new JButton("Back");
        back.setBounds(220,470,180,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setVisible(true);
        setSize(800,570);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new AddReception();
        }else if(ae.getSource()==addCustomer){

            String id=(String)idChoice.getSelectedItem();
            String idNo=idNoTextField.getText();
            String name=nameTextField.getText();
            String gender="";
            if(male.isSelected()){
                gender="Male";
            } else if (female.isSelected()) {
                gender="Female";
            }
            String country=countryTextField.getText();
            String allocatedRoomNo=allocatedRoom.getSelectedItem();
            String time=checkInTimeLabel.getText();
            String deposit=depositTextField.getText();

            try{
                Conn c=new Conn();
                String query1="insert into customer values('"+id+"','"+idNo+"','"+name+"','"+gender+"','"+country+"','"+allocatedRoomNo+"','"+time+"','"+deposit+"')";
                String query2="update room set availabilityStatus='Occupied' where roomNo='"+allocatedRoomNo+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"New Customer added successfully");
                setVisible(false);

            }catch(Exception e){
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new NewCustomerForm();
    }
}

