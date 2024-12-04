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
 * Servlet implementation class UpdateDiscountControl
 */
@WebServlet("/updatediscount")
public class UpdateDiscountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDiscountControl() {
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
		String id_raw = request.getParameter("id");
		String name = request.getParameter("title");
		String discountValue_raw = request.getParameter("discount");
		String startDate_raw = request.getParameter("startDate");
		String endDate_raw = request.getParameter("endDate");
		int id;
		String fail = "";
		String success = "";
		double discountValue;
		try {
			id = Integer.parseInt(id_raw);
			discountValue = Double.parseDouble(discountValue_raw);
			Discount dis = new Discount();
			dis.setId(id);
			dis.setTitle(name);
			dis.setDiscount(discountValue);
			dis.setStartDate(Date.valueOf(startDate_raw));
			dis.setEndDate(Date.valueOf(endDate_raw));
			DiscountDAO d = new DiscountDAO();
			d.update(dis);
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
