package orderApi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponUpdateApi
 */
@WebServlet("/OrderUpdateApi")
public class OrderUpdateApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Order Obj = new Order();
	
    public OrderUpdateApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output=Obj.updateOrder(request.getParameter("orderID"),
				request.getParameter("name"),
				request.getParameter("quantity"),
				request.getParameter("date"),
				request.getParameter("status"));
		response.getWriter().write(output);
		
		response.sendRedirect("OrderManagement/order-list.jsp");
	}

}
