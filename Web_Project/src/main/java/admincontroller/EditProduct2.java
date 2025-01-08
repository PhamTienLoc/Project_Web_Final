package admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ImageDAO;
import dao.ProductDAO;
import model.Image;
import model.Product;

/**
 * Servlet implementation class EditProduct2
 */
@WebServlet("/editproduct2")
public class EditProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProduct2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_raw = request.getParameter("id");
		String name = request.getParameter("productName");
		String thuongHieu = request.getParameter("brand");
		String gia = request.getParameter("price");
		String giamgia = request.getParameter("discount");
		String baoHanh = request.getParameter("warranty");
		String tonKho = request.getParameter("stock");
		String mota = request.getParameter("description");
		String theLoai = request.getParameter("category");

		ProductDAO pdao = new ProductDAO();
		ImageDAO idao = new ImageDAO();
		Product p = pdao.getProductByID(Integer.parseInt(id_raw));
		Image i = idao.getProductByID(id_raw);
		p.setTitle(name);
		p.setBrand(thuongHieu);
		p.setPrice(Double.parseDouble(gia));
		p.setDiscount(Integer.parseInt(giamgia));
		p.setWarranty(Integer.parseInt(baoHanh));
		p.setInventoryNumber(Integer.parseInt(tonKho));
		p.setDescription(mota);
		p.setCid(Integer.parseInt(theLoai));
		p.setUpdatedAt(new java.util.Date());

		HttpSession session = request.getSession();
		session.setAttribute("product", p);
		session.setAttribute("i", i);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/EditUploadFile.jsp");
		rd.forward(request, response);
	}

}
