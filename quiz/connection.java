package quiz;

import java.sql.*;

public class connection{
    Connection c;
    Statement s;
    public connection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Piyansu@2002");    
            s =c.createStatement(); 



        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  

