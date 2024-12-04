package admincontroller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class EditCategoryControl
 */
@WebServlet("/editcategory")
public class EditCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCategoryControl() {
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
		int cid;
		try {
			cid = Integer.parseInt(id);
			Category cte = new Category();
			cte.setCid(cid);
			CategoryDAO cd = new CategoryDAO();
			Category category = cd.selectById(cte);
			request.setAttribute("category", category);
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/admin/ModalEditCategory.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

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
