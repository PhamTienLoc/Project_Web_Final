package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class LoadMoreControl
 */
@WebServlet("/loadmore")
public class LoadMoreControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadMoreControl() {
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
		response.setCharacterEncoding("UTF-8");
		String amount = request.getParameter("exist");
		int iamount = Integer.parseInt(amount);
		ProductDAO pd = new ProductDAO();
		ArrayList<Product> list = pd.ChiLay4SPTiepTheo(iamount);
		PrintWriter out = response.getWriter();
		for (Product p : list) {
			out.println("<div class=\"product col-md-3 mb-4\">\r\n"
					+ "						<div class=\"card card-hover\">\r\n"
					+ "							<img src=\""+p.getThumbnail()+"\" class=\"card-img-top\"\r\n"
					+ "								alt=\"Product Image\">\r\n"
					+ "							<div class=\"card-body text-center\">\r\n"
					+ "								<h5 class=\"card-title\">"+p.getTitle()+"</h5>\r\n"
					+ "								<p class=\"card-text\">"+p.getPrice()+"</p>\r\n"
					+ "								 <a href=\"#\" class=\"btn btn-success\">Add to Cart</a>\r\n"
					+ "							</div>\r\n"
					+ "						</div>\r\n"
					+ "					</div>");
		}
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
