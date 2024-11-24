package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiscountDAO;
import model.Cart;
import model.Discount;

/**
 * Servlet implementation class ApplyDiscountControl
 */
@WebServlet("/applydiscount")
public class ApplyDiscountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplyDiscountControl() {
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
		double totalMoney = 0;
		String discount_raw = request.getParameter("discountCode");
		DiscountDAO disD = new DiscountDAO();
		Discount dis = disD.getDiscountByID(discount_raw);
		if (dis == null) {
			totalMoney = 0;
		} else {
			totalMoney = cart.geTotalMoney() * (1 - (dis.getDiscount() / 100));
		}
		ArrayList<Discount> listd = disD.selectAllDiscountValid();
		request.setAttribute("listDis", listd);
		request.setAttribute("disId", discount_raw);
		request.setAttribute("totalMoneyUseDis", totalMoney);
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
