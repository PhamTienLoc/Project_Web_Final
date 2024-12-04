package admincontroller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscountDAO;
import model.Discount;

/**
 * Servlet implementation class AddDiscountControl
 */
@WebServlet("/adddiscount")
public class AddDiscountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDiscountControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("title");
		String value = request.getParameter("discount");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		double discount_value;
		String fail = "";
		String success = "";
		try {
			discount_value = Double.parseDouble(value);
			Discount dis = new Discount();
			dis.setTitle(name);
			dis.setDiscount(discount_value);
			dis.setStartDate(Date.valueOf(startDate));
			dis.setEndDate(Date.valueOf(endDate));
			DiscountDAO d = new DiscountDAO();
			d.insert(dis);
			success = "Thay đổi thành công";
			request.setAttribute("success", success);
		} catch (Exception e) {
			fail = "Thay đổi thất bại";
			request.setAttribute("fail", fail);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admindiscount");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
