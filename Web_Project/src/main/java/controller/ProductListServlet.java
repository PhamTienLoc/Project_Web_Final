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
import model.Category;
import model.Product;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] priceRange = {
				"Dưới 1 triệu", 
				"Từ 1 đến 2 triệu", 
				"Từ 2 đến 5 triệu", 
				"Từ 5 đến 10 triệu",
				"Trên 10 triệu" 	
				};
		boolean[] priceRangeChecked = new boolean[priceRange.length + 1];
		priceRangeChecked[0] = true;
		
		HttpSession session = request.getSession();
		List<Category> categoryList = (List<Category>) session.getAttribute("categories");
		boolean[] categoryChecked = new boolean[categoryList.size() + 1];
		categoryChecked[0] = true;
		
		List<Product> productList = productDAO.selectAll();
		
		request.setAttribute("priceRange", priceRange);
		request.setAttribute("priceRangeChecked", priceRangeChecked);
		request.setAttribute("categoryChecked", categoryChecked);
		request.setAttribute("cid", 0);
		request.setAttribute("productList", productList);
		RequestDispatcher rd = request.getRequestDispatcher("Category.jsp");
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
