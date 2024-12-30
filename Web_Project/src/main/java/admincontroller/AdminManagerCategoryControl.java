package admincontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class AdminManagerCategoryControl
 */
@WebServlet("/adminCategoryManager")
public class AdminManagerCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CategoryDAO categoryDAO = new CategoryDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManagerCategoryControl() {
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

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "add":
				AddCategory(request, response);
				break;
			case "update":
				UpdateCategory(request, response);
				break;
			case "delete":
				DeleteCategory(request, response);
				break;
			default:
				break;
			}
		}

		ArrayList<Category> list = categoryDAO.selectAll();
		int page, numperpage = 7;
		int size = list.size();
		int num = (size % numperpage == 0 ? (size / numperpage) : ((size / numperpage) + 1));// số trang

		String xpage = request.getParameter("page");

		if (xpage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(xpage);
		}

		int start, end;
		start = (page - 1) * numperpage;
		end = Math.min(page * numperpage, size);

		List<Category> displayCategoryList = list.subList(start, end);
		request.setAttribute("listc", displayCategoryList);
		request.setAttribute("page", page);
		request.setAttribute("num", num);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ManagerCategory.jsp");
		rd.forward(request, response);
	}

	private void DeleteCategory(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String fail = "";
		String success = "";
		
		Category c = new Category();
		c.setCid(Integer.parseInt(id));
		Category categoryCheck = categoryDAO.selectById(c);
		
		int row = categoryDAO.delete(categoryCheck);
		
		if (row > 0) {
			success = "Xóa danh mục thành công";
			request.setAttribute("success", success);
		} else {
			fail = "Xóa danh mục thất bại";
			request.setAttribute("fail", fail);
		}

	}

	private void UpdateCategory(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String thumb = request.getParameter("thumb");
		String fail = "";
		String success = "";
		
		Category c = new Category();
		c.setCid(Integer.parseInt(id));
		Category categoryCheck = categoryDAO.selectById(c);
		
		categoryCheck.setCname(title);
		categoryCheck.setThumb(thumb);
		
		int row = categoryDAO.update(categoryCheck);
		
		if (row > 0) {
			success = "Cập nhật thông tin danh mục thành công";
			request.setAttribute("success", success);
		} else {
			fail = "Cập nhật thông tin danh mục thất bại";
			request.setAttribute("fail", fail);
		}

	}

	private void AddCategory(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String thumb = request.getParameter("thumb");
		String fail = "";
		String success = "";
		
		Category c = new Category();
		if (categoryDAO.checkCategoryName(title)) {
			fail = "Tên danh mục đã tồn tại";
			request.setAttribute("fail", fail);
		} else {
			c.setCname(title);
			c.setThumb(thumb);
			
			int row = categoryDAO.insert(c);
			
			if (row > 0) {
				success = "Thêm danh mục thành công";
				request.setAttribute("success", success);
			} else {
				fail = "Thêm danh mục thất bại";
				request.setAttribute("fail", fail);
			}
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
