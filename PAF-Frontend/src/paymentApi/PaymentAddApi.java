package paymentApi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponAddApi
 */
@WebServlet("/PaymentAddApi")
public class PaymentAddApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Payment paymentObj = new Payment();
	
    public PaymentAddApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output=paymentObj.insertPayment(request.getParameter("cardType"),
				request.getParameter("cardNumber"),
				request.getParameter("expireDate"),
				request.getParameter("cvc"));
		response.getWriter().write(output);
		
		response.sendRedirect("PaymentManagement/payment-list.jsp");
	}

}
