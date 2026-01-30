package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener{

    JTable table;
    DefaultTableModel model;
    JButton back;
    Room(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        String[] columns = {"Room No", "Availability", "Clean Status", "Price", "Bed Type"};
        model = new DefaultTableModel(columns, 0);

        table=new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 40, 500, 300);
        add(sp);

        
        try{
            Conn c=new Conn();
            String query="select * from room";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                        rs.getString("roomNo"),
                        rs.getString("availabilityStatus"),
                        rs.getString("cleaningStatus"),
                        rs.getString("price"),
                        rs.getString("bedType")
                };
                model.addRow(row);
            }

        }catch (Exception e){
            System.out.println(e);
        }

        back =new JButton("Back");
        back.setBounds(200,400,100,30);
        back.setFont(new Font("System",Font.PLAIN,18));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(300,200,1050,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new AddReception();
    }

    public static void main(String[] args) {
        new Room();
    }
}
