package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiscountDAO;
import dao.ProductDAO;
import model.Cart;
import model.Discount;
import model.Item;
import model.Product;

/**
 * Servlet implementation class ProcessPlusAndSubtractControl
 */
@WebServlet("/updatequantity")
public class UpdateQuantityControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateQuantityControl() {
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
		String num_raw = request.getParameter("num").trim();
		String pid_raw = request.getParameter("id");
		int num, pid;

		try {

			num = Integer.parseInt(num_raw);
			pid = Integer.parseInt(pid_raw);
			if ((num == -1) && (cart.getQuantityById(pid) <= 1)) {
				cart.removeItem(pid);
			} else {
				ProductDAO pd = new ProductDAO();
				Product p = pd.getProductByID(pid_raw);
				double price = p.getPrice(); // vẫn giá gốc đi
				Item t = new Item(p, num, price);
				cart.addItem(t);
			}
		} catch (NumberFormatException e) {

		}
		List<Item> list = cart.getItems();
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Cart.jsp");
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
