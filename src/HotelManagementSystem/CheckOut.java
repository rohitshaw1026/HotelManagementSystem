package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends  JFrame implements ActionListener {

    Choice id;
    JLabel roomNoTextField,checkInTextField,checkOutTextField,tick;
    JButton check,checkFinal,back;

    CheckOut(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/sixth.jpg"));
        Image i2=i1.getImage().getScaledInstance(380,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(440,60,380,300);
        add(image);

        JLabel label=new JLabel("Check Out");
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
        id.setBounds(180,90,180,30);
        id.setFont(new Font("System",Font.PLAIN,18));
        add(id);

        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/tick.png"));
        Image j2 =j1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon j3 =new ImageIcon(j2);
        tick=new JLabel(j3);
        tick.setBounds(380,90,30,30);
        tick.setVisible(false);
        add(tick);

        JLabel roomNo =new JLabel("Room No");
        roomNo.setBounds(20,150,150,30);
        roomNo.setFont(new Font("System",Font.BOLD,20));
        add(roomNo);

        roomNoTextField=new JLabel();
        roomNoTextField.setBounds(180,150,180,30);
        roomNoTextField.setFont(new Font("System",Font.BOLD,18));
        add(roomNoTextField);

        JLabel checkIn =new JLabel("Check-In");
        checkIn.setBounds(20,210,150,30);
        checkIn.setFont(new Font("System",Font.BOLD,20));
        add(checkIn);

        checkInTextField =new JLabel();
        checkInTextField.setBounds(180,210,220,30);
        checkInTextField.setFont(new Font("System",Font.BOLD,18));
        add(checkInTextField);

        JLabel checkOut =new JLabel("Check-Out");
        checkOut.setBounds(20,270,150,30);
        checkOut.setFont(new Font("System",Font.BOLD,20));
        add(checkOut);

        Date date=new Date();

        checkOutTextField =new JLabel(""+date);
        checkOutTextField.setBounds(180,270,220,30);
        checkOutTextField.setFont(new Font("System",Font.BOLD,16));
        add(checkOutTextField);

        check=new JButton("Check Details");
        check.setBounds(140,320,140,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        add(check);

        checkFinal=new JButton("Check-Out");
        checkFinal.setBounds(80,360,120,30);
        checkFinal.setForeground(Color.white);
        checkFinal.setBackground(Color.BLACK);
        checkFinal.addActionListener(this);
        add(checkFinal);

        back=new JButton("Back");
        back.setBounds(210,360,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(850,450);
        setLocation(400,200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String idNo=id.getSelectedItem();
            try{
                Conn c=new Conn();
                String query1="select c.deposit,r.price from customer c inner join room r on c.allocatedRoomNo=r.roomNo where c.idNo='"+idNo+"'";

                ResultSet rs=c.s.executeQuery(query1);
                while(rs.next()){
                    if(Integer.parseInt(rs.getString("deposit"))==Integer.parseInt((rs.getString("price")))){
                        tick.setVisible(true);
                    }else{
                        tick.setVisible(false);
                    }
                }

                String query2="select * from customer where idNo='"+idNo+"'";
                ResultSet rs2=c.s.executeQuery(query2);
                while(rs2.next()){
                    roomNoTextField.setText(rs2.getString("allocatedroomno"));
                    checkInTextField.setText(rs2.getString("time"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==checkFinal) {
            try{
                String idNo=id.getSelectedItem();
                Conn c=new Conn();
                String query1="delete from customer where idNo='"+idNo+"'";
                String query2="update room set availabilityStatus='Available' where roomNo='"+roomNoTextField.getText()+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Check Out Successful");

            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new AddReception();
        }

    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
