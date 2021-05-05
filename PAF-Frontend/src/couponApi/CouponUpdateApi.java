package couponApi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CouponUpdateApi
 */
@WebServlet("/CouponUpdateApi")
public class CouponUpdateApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Coupon couponObj = new Coupon();
	
    public CouponUpdateApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output=couponObj.updateCoupon(request.getParameter("couponID"),
				request.getParameter("name"),
				request.getParameter("expireDate"),
				request.getParameter("saving"),
				request.getParameter("description"));
		response.getWriter().write(output);
		
		response.sendRedirect("CouponManagement/coupon-list.jsp");
	}

}
