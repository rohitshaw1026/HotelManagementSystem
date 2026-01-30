package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRoom extends JFrame implements ActionListener{
    JTextField roomNoTextField,priceTextField;
    JComboBox<String> availableChoice,cleaningStatusChoice,bedTypeChoice;
    JButton addRoom,cancel;

    AddRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,40,600,400);
        add(image);

        JLabel label =new JLabel("Add Rooms");
        label.setBounds(120,20,150,30);
        label.setFont(new Font("System",Font.BOLD,22));
        add(label);

        JLabel roomNo =new JLabel("Room Number");
        roomNo.setBounds(30,80,170,30);
        roomNo.setFont(new Font("System",Font.BOLD,20));
        add(roomNo);

        roomNoTextField=new JTextField();
        roomNoTextField.setBounds(200,80,160,30);
        roomNoTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(roomNoTextField);

        JLabel available =new JLabel("Available");
        available.setBounds(30,140,170,30);
        available.setFont(new Font("System",Font.BOLD,20));
        add(available);

        String [] availableValues ={"Available","Occupied"};
        availableChoice=new JComboBox<>(availableValues); // adding a dropdown box with multiple options to choose
        availableChoice.setBounds(200,140,160,30);
        availableChoice.setFont(new Font("System",Font.BOLD,20));
        availableChoice.setBackground(Color.WHITE);
        add(availableChoice);

        JLabel cleaningStatus =new JLabel("Cleaning Status");
        cleaningStatus.setBounds(30,200,170,30);
        cleaningStatus.setFont(new Font("System",Font.BOLD,20));
        add(cleaningStatus);

        String [] cleaningStatusValues ={"Cleaned","Dirty"};
        cleaningStatusChoice=new JComboBox<>(cleaningStatusValues); // adding a dropdown box with multiple options to choose
        cleaningStatusChoice.setBounds(200,200,160,30);
        cleaningStatusChoice.setFont(new Font("System",Font.BOLD,20));
        cleaningStatusChoice.setBackground(Color.WHITE);
        add(cleaningStatusChoice);

        JLabel price =new JLabel("Price");
        price.setBounds(30,270,170,30);
        price.setFont(new Font("System",Font.BOLD,20));
        add(price);

        priceTextField=new JTextField();
        priceTextField.setBounds(200,270,160,30);
        priceTextField.setFont(new Font("Ariel",Font.BOLD,22));
        add(priceTextField);

        JLabel bedType =new JLabel("Bed Type");
        bedType.setBounds(30,340,170,30);
        bedType.setFont(new Font("System",Font.BOLD,20));
        add(bedType);

        String [] bedTypeValues ={"Single Bed","Double Bed"};
        bedTypeChoice=new JComboBox<>(bedTypeValues); // adding a dropdown box with multiple options to choose
        bedTypeChoice.setBounds(200,340,160,30);
        bedTypeChoice.setFont(new Font("System",Font.BOLD,20));
        bedTypeChoice.setBackground(Color.WHITE);
        add(bedTypeChoice);

        addRoom=new JButton("Add Room");
        addRoom.setBounds(30,400,150,30);
        addRoom.setFont(new Font("System",Font.PLAIN,18));
        addRoom.setForeground(Color.white);
        addRoom.setBackground(Color.BLACK);
        addRoom.addActionListener(this);
        add(addRoom);

        cancel =new JButton("Cancel");
        cancel.setBounds(200,400,160,30);
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
        }else if(ae.getSource()==addRoom){
            String roomNO=roomNoTextField.getText();
            String available=(String)availableChoice.getSelectedItem();
            String cleaningStatus=(String)cleaningStatusChoice.getSelectedItem();
            String price=priceTextField.getText();
            String bedType=(String)bedTypeChoice.getSelectedItem();

            try{
                Conn c=new Conn();
                String query="insert into room values('"+roomNO+"','"+available+"','"+cleaningStatus+"','"+price+"','"+bedType+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Room added successfully");

                setVisible(false);

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
