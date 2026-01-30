package HotelManagementSystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); //registering oracle driver
            c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","hotel","hotel123");// getting connection
            s=c.createStatement();// creating sql query

        }catch(Exception e){
            System.out.println(e);
        }
    }
}