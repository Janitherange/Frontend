package authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.UserConnection;

@WebServlet("/registerSeller")
public class SellerRegister extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public SellerRegister() {
		 
	}
	
	UserConnection sellerConnection = new UserConnection();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
      
		
		try{
			
			Connection connect = sellerConnection.getConnection();
			
			if (connect == null){
				System.out.println("Error while connecting to the database");
			}
			
			// create a prepared statement
			String query = " insert into seller (`sellerID`,`email`,`password`,`name`,`dob`,`phone`,`address`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, request.getParameter("email"));
			preparedStmt.setString(3, request.getParameter("password"));
			preparedStmt.setString(4, request.getParameter("name"));
			preparedStmt.setString(5, request.getParameter("dob"));
			preparedStmt.setInt(6, Integer.parseInt(request.getParameter("phone")));
			preparedStmt.setString(7, request.getParameter("address")); 
			
			preparedStmt.execute();
			connect.close();
			
			response.sendRedirect(request.getContextPath()+"/UserManagemnt/Seller/home-seller.jsp");
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
