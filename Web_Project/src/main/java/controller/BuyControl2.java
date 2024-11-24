package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Item;
import model.Product;

/**
 * Servlet implementation class BuyControl2
 */
@WebServlet("/buy2")
public class BuyControl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyControl2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
//		Double totalMoneyObj = (Double) session.getAttribute("totalMoney");
//		double totalMoney = (totalMoneyObj != null) ? totalMoneyObj : 0.0;

		String quantity_raw = request.getParameter("quantity");
		String pid = request.getParameter("id");
		int quantity;
		try {
			quantity = Integer.parseInt(quantity_raw);

			ProductDAO pd = new ProductDAO();
			Product p = pd.getProductByID(pid);

			double price = p.getPrice();
			Item t = new Item(p, quantity, price);
			cart.addItem(t);

//			totalMoney += cart.geTotalMoney();

		} catch (Exception e) {
			quantity = 1;
		}
		List<Item> list = cart.getItems();
//		session.setAttribute("totalMoney", totalMoney);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
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
