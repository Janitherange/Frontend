package productApi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductAddApi
 */
@WebServlet("/ProductAddApi")
public class ProductAddApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Product productObj = new Product();
	
    public ProductAddApi() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output=productObj.insertProduct(request.getParameter("name"), 
				request.getParameter("price"), 
				request.getParameter("category"), 
				request.getParameter("stock"),
				request.getParameter("description"));
		
		response.getWriter().write(output);
		
		response.sendRedirect("ProductManagement/product-list.jsp");
	}

}
