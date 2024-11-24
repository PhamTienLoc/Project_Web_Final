package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Order;
import model.User;

/**
 * Servlet implementation class FormCheckoutControl
 */
@WebServlet("/formcheckout")
public class FormCheckoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormCheckoutControl() {
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
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if (us == null) {
			us = new User();
		}
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phonenumber");
		String address = request.getParameter("address");
		String note = request.getParameter("note");
		Order od = new Order(us.getId(), fullName, email, phoneNumber, address, note, 0, null);
		session.setAttribute("order", od);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/PaymentMethod.jsp");
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
