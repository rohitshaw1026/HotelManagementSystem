package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    DefaultTableModel model;
    JButton back;
    CustomerInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.white);


        String[] columns = {"Id", "Id No", "Name", "Gender", "Country","Allocated Room No","Time","Deposit"};
        model = new DefaultTableModel(columns, 0);

        table=new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 40, 1050, 400);
        add(sp);


        try{
            Conn c=new Conn();
            String query="select * from customer";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                        rs.getString("id"),
                        rs.getString("idno"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("country"),
                        rs.getString("allocatedRoomNo"),
                        rs.getString("time"),
                        rs.getString("deposit")
                };
                model.addRow(row);
            }

        }catch (Exception e){
            System.out.println(e);
        }

        back =new JButton("Back");
        back.setBounds(450,480,100,30);
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
        new CustomerInfo();
    }
}

