package controller;

import java.io.IOException;
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
 * Servlet implementation class BuyControl
 */
@WebServlet("/buy")
public class BuyControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyControl() {
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

		String pid_raw = request.getParameter("id");
		String cid_raw = request.getParameter("cid");
		String quantity_raw = request.getParameter("quantity");

		int quantity;
		try {
			quantity = Integer.parseInt(quantity_raw);

			ProductDAO pd = new ProductDAO();
			Product p = pd.getProductByID(pid_raw);

			double price = p.getPrice(); // vẫn giá gốc đi
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/detail");
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
