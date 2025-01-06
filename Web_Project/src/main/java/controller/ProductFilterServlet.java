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

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ProductFilter
 */
@WebServlet("/productFilter")
public class ProductFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private ProductDAO productDAO = new ProductDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductFilterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] priceRange = { "Dưới 1 triệu", "Từ 1 đến 2 triệu", "Từ 2 đến 5 triệu", "Từ 5 đến 10 triệu",
				"Trên 10 triệu" };
		boolean[] priceRangeChecked = new boolean[priceRange.length + 1];

		HttpSession session = request.getSession();
		List<Category> categories = (List<Category>) session.getAttribute("categories");
		if (categories == null) {
			categories = categoryDAO.selectAll();
			session.setAttribute("categories", categories);
		}
		boolean[] categoryChecked = new boolean[categories.size() + 1];

		List<Product> products = new ArrayList<Product>();

		String cid_raw = request.getParameter("cid");
		String[] categoryId_raw = request.getParameterValues("categoryId");
		String[] priceIds = request.getParameterValues("priceId");

		int cid = 0;
		int[] categoryId = null;

		if (cid_raw != null) {
			cid = Integer.parseInt(cid_raw);
			products = productDAO.getProductByCID(cid + "");
			if (cid == 0) {
				categoryChecked[0] = true;
				products = productDAO.selectAll();
			}
		}

		if (categoryId_raw != null) {
			categoryId = new int[categoryId_raw.length];
			for (int i = 0; i < categoryId.length; i++) {
				categoryId[i] = Integer.parseInt(categoryId_raw[i]);
			}
			products = productDAO.getProductByCheckedCategory(categoryId);
		}

		if (priceIds != null) {
			double from = 0, to = 0;
			for (int i = 0; i < priceIds.length; i++) {
				List<Product> temp = new ArrayList<Product>();
				if (priceIds[i].equals("0")) {
					from = 0;
					to = 100000000;
					products = productDAO.getProductByPriceRange(from, to);
					priceRangeChecked[0] = true;
					break;
				} else {
					if (priceIds[i].equals("1")) {
						from = 0;
						to = 1000000;
						temp = productDAO.getProductByPriceRange(from, to);
						products.addAll(temp);
						priceRangeChecked[1] = true;
					}
					if (priceIds[i].equals("2")) {
						from = 1000000;
						to = 2000000;
						temp = productDAO.getProductByPriceRange(from, to);
						products.addAll(temp);
						priceRangeChecked[2] = true;
					}
					if (priceIds[i].equals("3")) {
						from = 2000000;
						to = 5000000;
						temp = productDAO.getProductByPriceRange(from, to);
						products.addAll(temp);
						priceRangeChecked[3] = true;
					}
					if (priceIds[i].equals("4")) {
						from = 5000000;
						to = 10000000;
						temp = productDAO.getProductByPriceRange(from, to);
						products.addAll(temp);
						priceRangeChecked[4] = true;
					}
					if (priceIds[i].equals("5")) {
						from = 10000000;
						to = 100000000;
						temp = productDAO.getProductByPriceRange(from, to);
						products.addAll(temp);
						priceRangeChecked[5] = true;
					}
				}
			}
		}

		if (priceIds == null) {
			priceRangeChecked[0] = true;
		}

		if (cid_raw == null) {
			categoryChecked[0] = true;
		}

		if ((categoryId_raw != null) && (categoryId[0] != 0)) {
			categoryChecked[0] = false;
			for (int i = 1; i < categoryChecked.length; i++) {
				if (isChecked(categories.get(i - 1).getCid(), categoryId)) {
					categoryChecked[i] = true;
				} else {
					categoryChecked[i] = false;
				}
			}
		}

		request.setAttribute("categories", categories);
		request.setAttribute("categoryChecked", categoryChecked);
		request.setAttribute("cid", cid);
		request.setAttribute("priceRange", priceRange);
		request.setAttribute("priceRangeChecked", priceRangeChecked);
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("Category.jsp");
		rd.forward(request, response);
	}

	private boolean isChecked(int lastCheckId, int[] ids) {
		if (ids == null	|| ids.length == 0) {
			return false;
		} 
		for (int id : ids) {
			if (id == lastCheckId) {
	            return true;
	        }
		}
		return false;
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
