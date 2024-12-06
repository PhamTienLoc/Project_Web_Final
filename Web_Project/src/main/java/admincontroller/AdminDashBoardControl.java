package admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscountDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.UserDAO;
import model.Discount;
import model.Order;
import model.Product;
import model.User;

/**
 * Servlet implementation class AdminDashBoardControl
 */
@WebServlet("/admindashboard")
public class AdminDashBoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDashBoardControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO ud = new UserDAO();
		ArrayList<User> listu = ud.selectAll();
		OrderDAO od = new OrderDAO();
		ArrayList<Order> listo = od.selectAll();
		DiscountDAO dd = new DiscountDAO();
		ArrayList<Discount> listd = dd.selectAll();
		ProductDAO pd = new ProductDAO();
		ArrayList<Product> listp = pd.selectAll();

		int total = 0;
		for (Order o : listo) {
			if (o.getStatus().equals("confirmed")) {
				total += o.getTotalMoney();
			}
		}
		request.setAttribute("sizeu", listu.size());
		request.setAttribute("sizeo", listo.size());
		request.setAttribute("sized", listd.size());
		request.setAttribute("sizep", listp.size());
		request.setAttribute("total", total);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/AdminDashBoard.jsp");
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
