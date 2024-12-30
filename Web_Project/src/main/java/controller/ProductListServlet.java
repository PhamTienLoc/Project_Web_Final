package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
import service.ProductService;

/**
 * Servlet implementation class ProductFilter
 */
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO = new CategoryDAO();
	private ProductDAO productDAO = new ProductDAO();
	private ProductService service = new ProductService();
	private static final int PRODUCTS_PER_PAGE = 8;
	private static final double MAX_PRICE = Double.MAX_VALUE;

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

		ArrayList<Product> products = new ArrayList<Product>();

		String[] categoryId_raw = request.getParameterValues("categoryId");
		String[] priceIds = request.getParameterValues("priceId");
		String param = request.getQueryString();
		if (param == null) param = "";
//		System.out.println("Before param: " + param);
		
		// Filter
		int[] categoryId = null;

		if (categoryId_raw != null) {
			categoryId = new int[categoryId_raw.length];
			for (int i = 0; i < categoryId.length; i++) {
				categoryId[i] = Integer.parseInt(categoryId_raw[i]);
				param = updateParam(param, "categoryId", categoryId_raw[i]);
				if (categoryId[i] == 0) {
					categoryChecked[0] = true;
				}
			}

			products = productDAO.getProductByCheckedCategory(categoryId);
		}

		if (priceIds != null) {
		    double[][] priceRanges = {
		        {0, MAX_PRICE},    
		        {0, 1000000},             
		        {1000000, 2000000},      
		        {2000000, 5000000},       
		        {5000000, 10000000},      
		        {10000000, MAX_PRICE}     
		    };

		    for (String priceId : priceIds) {
		        int id = Integer.parseInt(priceId);
		        param = updateParam(param, "priceId", priceId);
		        
		        if (id == 0) { 
		            products = productDAO.getProductByPriceRange(priceRanges[0][0], priceRanges[0][1]);
		            Arrays.fill(priceRangeChecked, false); 
		            priceRangeChecked[0] = true;          
		            break;                                
		        } else if (id >= 1 && id < priceRanges.length) {
		            List<Product> temp = productDAO.getProductByPriceRange(priceRanges[id][0], priceRanges[id][1]);
		            products.addAll(temp);
		            priceRangeChecked[id] = true;
		        }
		    }
		}

		if (priceIds == null && categoryId_raw == null) {
			products = productDAO.selectAll();
		}

		if (priceIds == null) {
			priceRangeChecked[0] = true;
		}

		if (categoryId_raw == null) {
			categoryChecked[0] = true;
		}

		if ((categoryId_raw != null) && (categoryId[0] != 0)) {
			categoryChecked[0] = false;
			for (int i = 1; i < categoryChecked.length; i++) {
				categoryChecked[i] = isChecked(categories.get(i - 1).getCid(), categoryId);
			}
		}
		
		// Sorting
		String sortBy = request.getParameter("sortBy");
		if (sortBy == null) {
		    sortBy = "newest"; 
		} else {
		    param = updateParam(param, "sortBy", sortBy);
		}
		
		ArrayList<Product> sortedProductList = service.sortProductListBy(products, sortBy);

		// Pagination
		String index = request.getParameter("index");
		int pageIndex = (index == null) ? 1 : Integer.parseInt(index);
		param = updateParam(param, "index", String.valueOf(pageIndex));
		int productPerPage = PRODUCTS_PER_PAGE;
		int totalProduct = products.size();
		int totalPage = (totalProduct % productPerPage == 0 ? (totalProduct / productPerPage)
				: ((totalProduct / productPerPage) + 1));

		int beginIndex = (pageIndex - 1) * productPerPage;
		int endIndex = Math.min(pageIndex * productPerPage, totalProduct);
		List<Product> displayProductsByPage = sortedProductList.subList(beginIndex, endIndex);
//		System.out.println("Products: " + displayProductsByPage.size());
//		System.out.println("Final param: " + param);
		
//		response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        for (Product product : displayProductsByPage) {
//        	System.out.println(product);
//            out.println("<div class=\"product col-md-3 mb-4\">");
//            out.println("    <div class=\"card card-hover\">");
//            out.println("        <a href=\"/detail?id=" + product.getId() + "&cid=" + product.getCid() + "\">");
//            out.println("            <img src=\"" + product.getThumbnail() + "\" class=\"card-img-top\" alt=\"Product Image\">");
//            out.println("        </a>");
//            out.println("        <div class=\"card-body text-center\">");
//            out.println("            <a href=\"/detail?id=" + product.getId() + "&cid=" + product.getCid() + "\" class=\"text-decoration-none\">");
//            out.println("                <h5 class=\"card-title\">" + product.getTitle() + "</h5>");
//            out.println("            </a>");
//            out.println("            <p class=\"card-text\">" + String.format("%,.2f", product.getPrice()) + "đ</p>");
//            out.println("            <form action=\"buy2\" method=\"get\" onsubmit=\"return buy(event, this);\">");
//            out.println("                <input type=\"hidden\" name=\"id\" value=\"" + product.getId() + "\">");
//            out.println("                <input type=\"hidden\" name=\"quantity\" value=\"1\">");
//            out.println("                <button type=\"submit\" class=\"btn btn-success\">Thêm vào giỏ hàng</button>");
//            out.println("            </form>");
//            out.println("        </div>");
//            out.println("    </div>");
//            out.println("</div>");
//        }
//        out.close();
		
		request.setAttribute("categories", categories);
		request.setAttribute("categoryChecked", categoryChecked);
		request.setAttribute("param", param);
		request.setAttribute("priceRange", priceRange);
		request.setAttribute("totalProduct", totalProduct);
		request.setAttribute("priceRangeChecked", priceRangeChecked);
		request.setAttribute("products", displayProductsByPage);
		request.setAttribute("sortBy", sortBy);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageIndex", pageIndex);
		RequestDispatcher rd = request.getRequestDispatcher("Category.jsp");
		rd.forward(request, response);
	}

	private boolean isChecked(int lastCheckId, int[] ids) {
		if (ids == null || ids.length == 0) {
			return false;
		}
		for (int id : ids) {
			if (id == lastCheckId) {
				return true;
			}
		}
		return false;
	}
	
	private String updateParam(String param, String key, String value) {
	    if (param == null || param.isEmpty()) {
	        param = "";
	    }

	    String[] keyPairs = param.split("&");
	    List<String> updatedParams = new ArrayList<>();
	    List<String> keyValues = new ArrayList<>();

	    boolean exist = false;
	    for (String pair : keyPairs) {
	        if (pair.startsWith(key + "=")) {
	        	exist = true;
	        	keyValues.add(pair.split("=")[1]);
	        } else {
	            updatedParams.add(pair);
	        }
	    }

	    if (!exist) {
	        updatedParams.add(key + "=" + value);
	    } else {
	        if (!keyValues.contains(value)) {
	        	keyValues.add(value);
	        }

	        List<String> toRemove = new ArrayList<>();
	        for (String p : updatedParams) {
	            if (p.startsWith(key + "=")) {
	                toRemove.add(p); 
	            }
	        }
	        updatedParams.removeAll(toRemove); 

	        for (String newValue : keyValues) {
	            updatedParams.add(key + "=" + newValue);
	        }
	    }

	    return String.join("&", updatedParams);
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
