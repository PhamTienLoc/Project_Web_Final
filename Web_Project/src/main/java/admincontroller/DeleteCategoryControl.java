package admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.DiscountDAO;

/**
 * Servlet implementation class DeleteCategoryControl
 */
@WebServlet("/deletecategory")
public class DeleteCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCategoryControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		CategoryDAO d = new CategoryDAO();
		int ketQua = d.deleteCategory(id);
		String fail = "";
		String success = "";
		if (ketQua > 0) {
			success = "Thay đổi thành công";
			request.setAttribute("success", success);
		} else {
			fail = "Thay đổi thất bại";
			request.setAttribute("fail", fail);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminmanagercategory");
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
