package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstScreen extends JFrame implements ActionListener{

    JButton next;

    FirstScreen(){

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/first.jpg"));
        JLabel b_image=new JLabel(i1);
        b_image.setBounds(0,0,1366,565);
        add(b_image);

        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(50,450,800,70);
        text.setFont(new Font("System",Font.ITALIC,55));
        text.setForeground(Color.WHITE);
        b_image.add(text);

        next=new JButton("Next");
        next.setBounds(1200,450,100,40);
        next.setFont(new Font("System",Font.BOLD,22));
        next.setForeground(Color.CYAN);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        b_image.add(next);


        setSize(1366,565);
        setLocation(100,100);
        setVisible(true);

        while(true){ // using an infinite while loop to generate a blinking effect
            text.setVisible(false);
            try{
                Thread.sleep(500); // the code of execution will stop for 500 milliseconds
            }catch(Exception e){
                e.printStackTrace(); // printing the error
            }
            text.setVisible(true);
            // using a 2nd try-catch so that after visible,it also takes a pause for 500 milli instead of directly becoming invisible
            try{
                Thread.sleep(500); // the code of execution will stop for 500 milliseconds
            }catch(Exception e){
                e.printStackTrace(); // printing the error
            }
        }
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new FirstScreen();
    }
}
