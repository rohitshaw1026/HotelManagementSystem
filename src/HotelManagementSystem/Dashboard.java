package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem reception,addEmployee,addRoom,addDriver;
    Dashboard(){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,860,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel b_image=new JLabel(i3);
        b_image.setBounds(0,0,1550,860);
        add(b_image);

        JLabel text=new JLabel("The Royal Group Welcomes You");
        text.setBounds(440,50,800,50);
        text.setFont(new Font("Rale way",Font.ITALIC,45));
        text.setForeground(Color.WHITE);
        b_image.add(text);



        JMenuBar mb=new JMenuBar();// creating a menubar
        mb.setBounds(0,0,1550,30);
        b_image.add(mb);


        JMenu hotelManagement=new JMenu("Hotel Management "); // adding menu inside menubar
        hotelManagement.setForeground(Color.red);
        mb.add(hotelManagement);

        reception=new JMenuItem("Reception");// adding menuItems inside hotelManagement menu
        reception.addActionListener(this);
        hotelManagement.add(reception);


        JMenu admin=new JMenu("Admin "); // adding menu inside menubar
        admin.setForeground(Color.MAGENTA);
        mb.add(admin);

        addEmployee =new JMenuItem("Add Employee");//adding menuItems inside admin menu
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        addRoom =new JMenuItem("Add Room");//adding menuItems inside admin menu
        addRoom.addActionListener(this);
        admin.add(addRoom);

        addDriver =new JMenuItem("Add Driver");//adding menuItems inside admin menu
        addDriver.addActionListener(this);
        admin.add(addDriver);



        
        setVisible(true);
        setSize(1550,860);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){ // in case of menu item we need to use getActionCommand. by doing this we get the text of the menu item
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Room")){
            new AddRoom();
        }else if(ae.getActionCommand().equals("Add Driver")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new AddReception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
