package com.example.FormProject.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;
import com.example.FormProject.model.Form;

@Repository("FormRepo")
public class FormRepo {

	protected static final Logger logger = Logger.getLogger(FormRepo.class.getName());
    
    java.lang.String dbDriver = "com.mysql.cj.jdbc.Driver";
    java.lang.String url =  "jdbc:mysql://localhost:3306/bankdb";
    java.lang.String username = "root";
    java.lang.String password = "Prav@14101992";

    
    public FormRepo() {
           
    }

    public Form findbyCustomerId(int id) {
                
       Form form = null;
        
        logger.info("In repository : findbyUserId method: UserId : " + id);
  
        try {
			Class.forName(dbDriver);
			Connection con = DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps = con.prepareStatement("select id,firstname,lastName,address from customer where id = ?;");
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("id");
 				String firstName = rs.getString("firstName");
 				String lastName = rs.getString("lastName");
 				String address = rs.getString("address");
 				
 				form = new Form();
 				form.setId(Id);
 				form.setFirstName(firstName);
 				form.setLastName(lastName);
 				form.setAddress(address);
 			}
					
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        return (Form) form;
    }

    
       
  
   public String addCustomer(Form form) {
   	      
       logger.info("In  repository : addCustomer method: UserId : ");
       String str = null;
       
       try {
	        Class.forName(dbDriver);
			Connection con = DriverManager.getConnection(url,username,password);
			
			Form form1 = (Form) form;
	  
			PreparedStatement st = con.prepareStatement("insert into customer (firstName, lastName, address) values (?,?,?);");
			
	        st.setString(1, form1.getFirstName());
	        st.setString(2, form1.getLastName());
	        st.setString(3, form1.getAddress());
	         
	        st.executeUpdate();
	        
	               
	        st.close();
	        con.close();
	 
			str = (String) "SUCCESS";
	        
			return str;
       } catch (SQLException e) {
       	e.printStackTrace();
       } catch (Exception e) {
       	e.printStackTrace();
       } 
       return str;
   }
}