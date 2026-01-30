package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    JButton check,update,back;
    JTextField roomNoTextField,availabilityTextField,cleaningStatusTextField;
    Choice id;
    UpdateRoomStatus(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(580,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,40,580,400);
        add(image);

        JLabel label=new JLabel("Update Room Status");
        label.setBounds(120,25,250,30);
        label.setFont(new Font("System",Font.BOLD,22));
        label.setForeground(Color.BLUE);
        add(label);

        JLabel customerId=new JLabel("Customer-Id");
        customerId.setBounds(20,90,150,30);
        customerId.setFont(new Font("System",Font.BOLD,20));
        add(customerId);

        id=new Choice();
        try{
            Conn c=new Conn();
            String query="select * from customer";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                id.add(rs.getString("idNo"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        id.setBounds(200,90,200,30);
        id.setFont(new Font("System",Font.PLAIN,18));
        add(id);

        JLabel roomNo =new JLabel("Room No");
        roomNo.setBounds(20,150,150,30);
        roomNo.setFont(new Font("System",Font.BOLD,20));
        add(roomNo);

        roomNoTextField=new JTextField();
        roomNoTextField.setEditable(false);
        roomNoTextField.setBounds(200,150,200,30);
        roomNoTextField.setFont(new Font("System",Font.BOLD,18));
        add(roomNoTextField);

        JLabel availability =new JLabel("Availability");
        availability.setBounds(20,210,150,30);
        availability.setFont(new Font("System",Font.BOLD,20));
        add(availability);

        availabilityTextField=new JTextField();
        availabilityTextField.setBounds(200,210,200,30);
        availabilityTextField.setFont(new Font("System",Font.BOLD,18));
        add(availabilityTextField);

        JLabel cleaningStatus =new JLabel("Cleaning Status");
        cleaningStatus.setBounds(20,270,150,30);
        cleaningStatus.setFont(new Font("System",Font.BOLD,20));
        add(cleaningStatus);

        cleaningStatusTextField=new JTextField();
        cleaningStatusTextField.setBounds(200,270,200,30);
        cleaningStatusTextField.setFont(new Font("System",Font.BOLD,18));
        add(cleaningStatusTextField);

        check=new JButton("Check");
        check.setBounds(130,340,100,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(20,400,100,30);
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(240,400,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(1050,550);
        setLocation(250,200);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check) {
            String idNo = id.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "select c.allocatedRoomNo,r.availabilityStatus,r.cleaningStatus from customer c inner join room r on c.allocatedRoomNo=r.roomNo where idNo='" + idNo + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    roomNoTextField.setText(rs.getString("allocatedRoomNo"));
                    availabilityTextField.setText(rs.getString("availabilityStatus"));
                    cleaningStatusTextField.setText(rs.getString("cleaningStatus"));
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
         else if (ae.getSource()==update) {
            String roomNo=roomNoTextField.getText();
            String availability=availabilityTextField.getText();
            String cleaningStatus=cleaningStatusTextField.getText();
            try {
                Conn c=new Conn();
                String query="update room set availabilityStatus='"+availability+"', cleaningStatus='"+cleaningStatus+"'" +" where roomNo='"+roomNo+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Room Updated successfully");

            }catch (Exception e){
                System.out.println(e);
            }
       }
        else{
            setVisible(false);
            new AddReception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}
