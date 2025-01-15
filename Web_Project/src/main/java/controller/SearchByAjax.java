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
 * Servlet implementation class SearchByAjax
 */
@WebServlet("/searchAjax")
public class SearchByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = new ProductDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String searchString = request.getParameter("searchString");
		ArrayList<Product> list = productDAO.searchByName(searchString);
		
		PrintWriter out = response.getWriter();
		for (Product product : list) {
          out.println("<div class=\"product col-md-3 mb-4\">");
          out.println("    <div class=\"card card-hover\">");
          out.println("        <a href=\"detail?id=" + product.getId() + "&cid=" + product.getCid() + "\">");
          out.println("            <img src="+ request.getContextPath() +"/image/image1/" + product.getThumbnail() + " class=\"card-img-top\" alt=\"Product Image\">");
          out.println("        </a>");
          out.println("        <div class=\"card-body text-center\">");
          out.println("            <a href=\"/detail?id=" + product.getId() + "&cid=" + product.getCid() + "\" class=\"text-decoration-none\">");
          out.println("                <h5 class=\"card-title\">" + product.getTitle() + "</h5>");
          out.println("            </a>");
          out.println("            <p class=\"card-text\">" + String.format("%,.2f", product.getPrice()) + "đ</p>");
          out.println("            <form action=\"buy2\" method=\"get\" onsubmit=\"return buy(event, this);\">");
          out.println("                <input type=\"hidden\" name=\"id\" value=\"" + product.getId() + "\">");
          out.println("                <input type=\"hidden\" name=\"quantity\" value=\"1\">");
          out.println("                <button type=\"submit\" class=\"btn btn-success\">Thêm vào giỏ hàng</button>");
          out.println("            </form>");
          out.println("        </div>");
          out.println("    </div>");
          out.println("</div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
