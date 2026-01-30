package HotelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AllEmployeeInfo extends JFrame implements ActionListener{

    JTable table;
    DefaultTableModel model;
    JButton back;
    AllEmployeeInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.white);


        String[] columns = {"Name", "Age", "Gender", "Job Role", "Salary","Phone","Email","Aadhaar"};
        model = new DefaultTableModel(columns, 0);

        table=new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 40, 885, 400);
        add(sp);


        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"),
                        rs.getString("Age"),
                        rs.getString("gender"),
                        rs.getString("jobrole"),
                        rs.getString("salary"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("Aadhar")
                };
                model.addRow(row);
            }

        }catch (Exception e){
            System.out.println(e);
        }

        back =new JButton("Back");
        back.setBounds(390,480,100,30);
        back.setFont(new Font("System",Font.PLAIN,18));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(300,200,900,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new AddReception();
    }

    public static void main(String[] args) {
        new AllEmployeeInfo();
    }
}
