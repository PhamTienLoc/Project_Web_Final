package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// bước 1 get data from dao
		request.setCharacterEncoding("UTF-8");
		ProductDAO pdao = new ProductDAO();
		CategoryDAO cdao = new CategoryDAO();
		ArrayList<Product> list = pdao.selectAll();
		ArrayList<Category> list1 = cdao.selectAll();
		Product pLast = pdao.getProductLast();
		// b2 : set data to jsp
		request.setAttribute("listP", list);
		request.setAttribute("listC", list1);
		request.setAttribute("p", pLast);
		String url = "/Home.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
