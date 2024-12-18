package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiscountDAO;
import model.Discount;
import model.Order;

/**
 * Servlet implementation class CheckControl
 */
@WebServlet("/check")
public class CheckControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method_raw = request.getParameter("method");
		String method = "";

		if (method_raw != null) {
			if (method_raw.equals("1")) {
				method = "VNPayQR";
			} else if (method_raw.equals("2")) {
				method = "Thẻ nội địa";
			} else if (method_raw.equals("3")) {
				method = "Thẻ quốc tế";
			} else if (method_raw.equals("4")) {
				method = "Ví VNPay";
			} else if (method_raw.equals("5")) {
				method = "Tiền mặt";
			}
		} else {
			response.sendRedirect("Cart.jsp");
			return;
		}

		HttpSession session = request.getSession();
		Order od = (Order) session.getAttribute("order");
		if (od == null) {
			od = new Order();
		}

		DiscountDAO dis = new DiscountDAO();
		ArrayList<Discount> listd = dis.selectAllDiscountValid();
		request.setAttribute("listDis", listd);
		od.setPaymentMethod(method);
		session.setAttribute("order", od);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Check.jsp");
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
