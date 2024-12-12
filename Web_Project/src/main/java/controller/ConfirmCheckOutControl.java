package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiscountDAO;
import dao.OrderDAO;
import model.Cart;
import model.Discount;
import model.Order;

/**
 * Servlet implementation class ConfirmCheckOutControl
 */
@WebServlet("/confirmcheckout")
public class ConfirmCheckOutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmCheckOutControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		String disID = request.getParameter("disID");
		DiscountDAO disDAO = new DiscountDAO();
		Discount dis = disDAO.getDiscountByID(disID);
		double totalMoney = 0;
		if (dis == null) {
			totalMoney = cart.geTotalMoney();
		} else {
			totalMoney = cart.geTotalMoney() * (1 - (dis.getDiscount() / 100));
		}
		Order od = (Order) session.getAttribute("order");

		String method = od.getPaymentMethod();
		if (method.equals(null)) {
			response.sendRedirect("home");
		}

		od.setTotalMoney(totalMoney);
		OrderDAO oDAO = new OrderDAO();
		oDAO.addOrder(od, cart);
		disDAO.deleteDiscount(disID);
		session.removeAttribute("cart");
		session.removeAttribute("order");
		session.removeAttribute("size");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Thank.jsp");
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
