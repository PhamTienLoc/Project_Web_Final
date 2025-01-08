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
					+ "							<a href=\"detail?id="+p.getId()+"&cid="+p.getCid()+"\"> <img src=\"/Web_Project/image/image1/"+p.getThumbnail()+"\"\r\n"
					+ "								class=\"card-img-top\" alt=\"Product Image\">\r\n"
					+ "							</a>\r\n"
					+ "							<div class=\"card-body text-center\">\r\n"
					+ "								<a href=\"detail?id="+p.getId()+"&cid="+p.getCid()+"\" class=\"text-decoration-none\">\r\n"
					+ "									<h5 class=\"card-title\">"+p.getTitle()+"</h5>\r\n"
					+ "								</a>\r\n"
					+ "\r\n"
					+ "								<p class=\"card-text\">\r\n"
					+ "									<fmt:formatNumber value=\""+p.getPrice()+"\" type=\"number\"\r\n"
					+ "										groupingUsed=\"true\" />\r\n"
					+ "									"+p.getPrice()+ "VNĐ\r\n"
					+ "								</p>\r\n"
					+ "								<form action=\"buy2\" method=\"get\"\r\n"
					+ "									onsubmit=\"return buy(event, this);\">\r\n"
					+ "									<input type=\"hidden\" name=\"id\" value=\""+p.getId()+"\"> <input\r\n"
					+ "										type=\"hidden\" name=\"quantity\" value=\"1\">\r\n"
					+ "									<button type=\"submit\" class=\"btn btn-success\">Thêm vào\r\n"
					+ "										giỏ hàng</button>\r\n"
					+ "								</form>\r\n"
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
