package HotelManagementSystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    DefaultTableModel model;
    JTable table;

    JCheckBox availabilityStatus;
    JComboBox<String > bedTypeChoice;
    JButton submit,back;
    SearchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel label=new JLabel("Search for Rooms");
        label.setBounds(360,20,250,30);
        label.setFont(new Font("System",Font.BOLD,25));
        add(label);

        JLabel bedType =new JLabel("Bed Type");
        bedType.setBounds(20,60,100,30);
        bedType.setFont(new Font("System",Font.BOLD,20));
        add(bedType);

        String [] bedTypeValues={"Single Bed","Double Bed"};
        bedTypeChoice=new JComboBox<>(bedTypeValues);
        bedTypeChoice.setBounds(130,60,140,30);
        bedTypeChoice.setFont(new Font("System",Font.PLAIN,18));
        bedTypeChoice.setBackground(Color.white);
        add(bedTypeChoice);

        availabilityStatus=new JCheckBox("Only Display Available");
        availabilityStatus.setBounds(650,60,240,30);
        availabilityStatus.setFont(new Font("System",Font.BOLD,20));
        availabilityStatus.setBackground(Color.white);
        add(availabilityStatus);

        String[] columns = {"Room No", "Availability", "Clean Status", "Price", "Bed Type"};
        model = new DefaultTableModel(columns, 0);

        table=new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 120, 900, 300);
        add(sp);

        try{
            Conn c=new Conn();
            String query="select * from room ";

            ResultSet rs=c.s.executeQuery(query);

            while(rs.next()){

                Object[] rows={
                        rs.getString("roomNo"),
                        rs.getString("availabilityStatus"),
                        rs.getString("cleaningStatus"),
                        rs.getString("price"),
                        rs.getString("bedType")
                };
                model.addRow(rows);
            }

        }catch (Exception e){
            System.out.println(e);
        }


        submit =new JButton("Submit");
        submit.setBounds(400,460,100,30);
        submit.setFont(new Font("System",Font.PLAIN,18));
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        back =new JButton("Back");
        back.setBounds(550,460,100,30);
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
            String availability="";
            if(availabilityStatus.isSelected()){
                availability=" and availabilityStatus='Available' ";
            }

            String bed=(String)bedTypeChoice.getSelectedItem();

            try{
                Conn c=new Conn();
                String query="select * from room where bedType='"+bed+"' "+availability;

                ResultSet rs=c.s.executeQuery(query);

                while(rs.next()){

                    Object[] rows={
                            rs.getString("roomNo"),
                            rs.getString("availabilityStatus"),
                            rs.getString("cleaningStatus"),
                            rs.getString("price"),
                            rs.getString("bedType")
                    };
                    model.addRow(rows);
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }


    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
