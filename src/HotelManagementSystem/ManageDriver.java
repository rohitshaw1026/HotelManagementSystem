package HotelManagementSystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ManageDriver extends JFrame implements ActionListener {

    DefaultTableModel model;
    JTable table;
    Choice carType;

    JCheckBox availabilityStatus;

    JButton submit,back;
    ManageDriver(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel label=new JLabel("Pick Up Service");
        label.setBounds(360,20,250,30);
        label.setFont(new Font("System",Font.BOLD,25));
        add(label);

        JLabel bedType =new JLabel("Type of Car");
        bedType.setBounds(20,60,120,30);
        bedType.setFont(new Font("System",Font.BOLD,20));
        add(bedType);

        carType=new Choice();
        try{
            Conn c=new Conn();
            String query="select distinct carModel from driver ";

            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                carType.add(rs.getString("carModel"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        carType.setBounds(160,60,150,30);
        carType.setFont(new Font("Ariel",Font.PLAIN,18));
        add(carType);

        String[] columns = {"Name", "Age", "Gender", "Car Company", "Car Model","Available Status","Location"};
        model = new DefaultTableModel(columns, 0);

        table=new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 120, 900, 300);
        add(sp);

        submit =new JButton("Submit");
        submit.setBounds(320,460,100,30);
        submit.setFont(new Font("System",Font.PLAIN,18));
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        back =new JButton("Back");
        back.setBounds(470,460,100,30);
        back.setFont(new Font("System",Font.PLAIN,18));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setBounds(300,200,930,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new AddReception();
        }else if(ae.getSource()==submit){
            model.setRowCount(0);// deleting the previously shown rows in order to avoid duplication of rows after multiple clicks of submit
            String carModel=carType.getSelectedItem();
            try{
                Conn c=new Conn();
                String query="select * from driver where carModel='"+carModel+"'";

                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    Object[] rows={
                            rs.getString("name"),
                            rs.getString("age"),
                            rs.getString("gender"),
                            rs.getString("carCompany"),
                            rs.getString("carModel"),
                            rs.getString("availabilityStatus"),
                            rs.getString("location")
                    };
                    model.addRow(rows);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new ManageDriver();
    }
}
