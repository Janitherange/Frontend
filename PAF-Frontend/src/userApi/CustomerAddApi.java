package userApi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addCustomerByAdmin")
public class CustomerAddApi extends HttpServlet {

	// auto generated 
    private static final long serialVersionUID = 1L; 
    
	public CustomerAddApi() {
		 
	}
	
	User obj = new User();

//	// As Submit button is hit from 
//    // the Web Page, request is made 
//    // to this Servlet and 
//    // doPost method is invoked. 
	@Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException { 
		
		String output=obj.insertCustomer(request.getParameter("email"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("dob"),
				request.getParameter("phone"),
				request.getParameter("address"));
		response.getWriter().write(output);
		
		response.sendRedirect("UserManagemnt/userCrud/customer-list.jsp");
	}
}
