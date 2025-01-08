package admincontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class AddProduct2
 */
@WebServlet("/addproduct2")
public class AddProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("productName");
		String thuongHieu = request.getParameter("brand");
		String gia = request.getParameter("price");
		String giamgia = request.getParameter("discount");
		String baoHanh = request.getParameter("warranty");
		String tonKho = request.getParameter("stock");
		String mota = request.getParameter("description");
		String theLoai = request.getParameter("category");
		Product p = new Product();
		try {
			double price = Double.parseDouble(gia);
			int warranty = Integer.parseInt(baoHanh);
			int discount = Integer.parseInt(giamgia);
			int inventoryNumber = Integer.parseInt(tonKho);
			int cid = Integer.parseInt(theLoai);
			p = new Product(name, thuongHieu, price, discount, warranty, inventoryNumber, mota, null,
					new java.util.Date(), new java.util.Date(), cid, 0);

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
		HttpSession session = request.getSession();
		session.setAttribute("product", p);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/AddImageProduct.jsp");
		rd.forward(request, response);

	}

}
