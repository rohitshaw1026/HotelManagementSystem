package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddReception extends JFrame implements ActionListener{

    JButton newCustomerForm,room,allEmployeeInfo,customerInfo,managerInfo,checkOut,updateStatus,updateRoomStatus,pickUpService,searchRoom,logout;

    AddReception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,475);
        add(image);

        newCustomerForm=new JButton("New Customer Form");
        newCustomerForm.setBounds(10,30,200,30);
        newCustomerForm.setForeground(Color.white);
        newCustomerForm.setBackground(Color.BLACK);
        newCustomerForm.addActionListener(this);
        add(newCustomerForm);

        room=new JButton("Room");
        room.setBounds(10,75,200,30);
        room.setForeground(Color.white);
        room.setBackground(Color.BLACK);
        room.addActionListener(this);
        add(room);


        allEmployeeInfo=new JButton("All Employee Info");
        allEmployeeInfo.setBounds(10,115,200,30);
        allEmployeeInfo.setForeground(Color.white);
        allEmployeeInfo.setBackground(Color.BLACK);
        allEmployeeInfo.addActionListener(this);
        add(allEmployeeInfo);

        customerInfo=new JButton("Customer Info");
        customerInfo.setBounds(10,160,200,30);
        customerInfo.setForeground(Color.white);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.addActionListener(this);
        add(customerInfo);

        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,205,200,30);
        managerInfo.setForeground(Color.white);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkOut=new JButton("Check Out");
        checkOut.setBounds(10,250,200,30);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.BLACK);
        checkOut.addActionListener(this);
        add(checkOut);

        updateStatus=new JButton("Update Status");
        updateStatus.setBounds(10,295,200,30);
        updateStatus.setForeground(Color.white);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.addActionListener(this);
        add(updateStatus);

        updateRoomStatus=new JButton("Update Room Status");
        updateRoomStatus.setBounds(10,340,200,30);
        updateRoomStatus.setForeground(Color.white);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);

        pickUpService=new JButton("Pick Up Service");
        pickUpService.setBounds(10,385,200,30);
        pickUpService.setForeground(Color.white);
        pickUpService.setBackground(Color.BLACK);
        pickUpService.addActionListener(this);
        add(pickUpService);

        searchRoom=new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setForeground(Color.white);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout=new JButton("Logout");
        logout.setBounds(10,475,200,30);
        logout.setForeground(Color.white);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);





        setVisible(true);
        setSize(800,570);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==logout){
            setVisible(false);
        }else if(ae.getSource()==newCustomerForm){
            setVisible(false);
            new NewCustomerForm();
        }else if(ae.getSource()==room){
            setVisible(false);
            new Room();
        }else if(ae.getSource()==allEmployeeInfo){
            setVisible(false);
            new AllEmployeeInfo();
        }else if(ae.getSource()==customerInfo){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==managerInfo){
        setVisible(false);
        new ManagerInfo();
        }else if(ae.getSource()==checkOut){
            setVisible(false);
            new CheckOut();
        }else if(ae.getSource()==updateStatus){
            setVisible(false);
            new UpdateStatus();
        }else if(ae.getSource()==updateRoomStatus){
            setVisible(false);
            new UpdateRoomStatus();
        }else if(ae.getSource()==pickUpService){
            setVisible(false);
            new ManageDriver();
        }else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }

    }

    public static void main(String[] args) {
        new AddReception();
    }
}
