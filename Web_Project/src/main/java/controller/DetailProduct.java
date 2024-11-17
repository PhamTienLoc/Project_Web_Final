package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImageDAO;
import dao.ProductDAO;
import model.Image;
import model.Product;

/**
 * Servlet implementation class DetailProduct
 */
@WebServlet("/detail")
public class DetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pid = request.getParameter("id");
		String cid = request.getParameter("cid");
		ProductDAO pd = new ProductDAO();
		ImageDAO imd = new ImageDAO();
		Image im = imd.getProductByID(pid);
		ArrayList<Product> list1 = pd.getProductByCID(cid);
		Product p = pd.getProductByID(pid);

		request.setAttribute("img", im);
		request.setAttribute("listP", list1);
		request.setAttribute("p", p);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/DetailProduct.jsp");
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
