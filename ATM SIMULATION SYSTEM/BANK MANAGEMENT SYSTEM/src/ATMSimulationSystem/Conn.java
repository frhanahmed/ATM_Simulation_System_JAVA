package ATMSimulationSystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            c =  DriverManager.getConnection("jdbc:mysql:///database-name-here","root","Your-Password-Here");
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

