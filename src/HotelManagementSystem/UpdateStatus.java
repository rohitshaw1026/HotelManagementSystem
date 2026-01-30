package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStatus extends JFrame implements ActionListener {

    JButton check,update,back;
    JTextField roomNoTextField,nameTextField,checkInTextField,amountPaidTextField,pendingAmountTextField;
    Choice id;
    UpdateStatus(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(480,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,40,500,400);
        add(image);

        JLabel label=new JLabel("Update Status");
        label.setBounds(120,25,200,30);
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
        roomNo.setBounds(20,140,150,30);
        roomNo.setFont(new Font("System",Font.BOLD,20));
        add(roomNo);

        roomNoTextField=new JTextField();
        roomNoTextField.setBounds(200,140,200,30);
        roomNoTextField.setFont(new Font("System",Font.BOLD,18));
        add(roomNoTextField);

        JLabel name =new JLabel("Name");
        name.setBounds(20,190,150,30);
        name.setFont(new Font("System",Font.BOLD,20));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(200,190,200,30);
        nameTextField.setFont(new Font("System",Font.BOLD,18));
        add(nameTextField);

        JLabel checkIn =new JLabel("Check-In");
        checkIn.setBounds(20,240,150,30);
        checkIn.setFont(new Font("System",Font.BOLD,20));
        add(checkIn);

        checkInTextField =new JTextField();
        checkInTextField.setBounds(200,240,200,30);
        checkInTextField.setFont(new Font("System",Font.BOLD,18));
        add(checkInTextField);

        JLabel amountPaid =new JLabel("Amount Paid");
        amountPaid.setBounds(20,290,150,30);
        amountPaid.setFont(new Font("System",Font.BOLD,20));
        add(amountPaid);

        amountPaidTextField =new JTextField();
        amountPaidTextField.setBounds(200,290,200,30);
        amountPaidTextField.setFont(new Font("System",Font.BOLD,18));
        add(amountPaidTextField);

        JLabel pendingAmount =new JLabel("Pending Amount");
        pendingAmount.setBounds(20,340,180,30);
        pendingAmount.setFont(new Font("System",Font.BOLD,20));
        add(pendingAmount);

        pendingAmountTextField =new JTextField();
        pendingAmountTextField.setBounds(200,340,200,30);
        pendingAmountTextField.setFont(new Font("System",Font.BOLD,18));
        add(pendingAmountTextField);

        check=new JButton("Check");
        check.setBounds(20,400,100,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,400,100,30);
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(280,400,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(1050,550);
        setLocation(250,200);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String idNo=id.getSelectedItem();
            try{
                Conn c=new Conn();
                String query="select * from customer where idNo='"+idNo+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()) {
                    roomNoTextField.setText(rs.getString("allocatedRoomNo"));
                    nameTextField.setText(rs.getString("name"));
                    checkInTextField.setText(rs.getString("time"));
                    amountPaidTextField.setText(rs.getString("deposit"));
                }

                String query2="select * from room where roomNo='"+roomNoTextField.getText()+"'";
                ResultSet rs2=c.s.executeQuery(query2);
                if(rs2.next()) {
                   int amount=Integer.parseInt(rs2.getString("price"))-Integer.parseInt(amountPaidTextField.getText());
                   pendingAmountTextField.setText(String.valueOf(amount));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==update) {
            String idNo=id.getSelectedItem();
            String roomNo=roomNoTextField.getText();
            String name=nameTextField.getText();
            String deposit=amountPaidTextField.getText();
            try {
                Conn c=new Conn();

                String query="update customer set allocatedRoomNo='"+roomNo+"', name='"+name+"', deposit='"+deposit+"' where idNo='"+idNo+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Updated successfully");

            }catch (Exception e){
                System.out.println(e);
            }

        }else{
            setVisible(false);
            new AddReception();
        }
    }

    public static void main(String[] args) {
        new UpdateStatus();
    }
}
