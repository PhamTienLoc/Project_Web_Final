package admincontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class AdminManagerUserControl
 */
@WebServlet("/adminUserManager")
public class AdminManagerUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO userDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManagerUserControl() {
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
				AddUser(request, response);
				break;
			case "update":
				UpdateUser(request, response);
				break;
			case "delete":
				DeleteUser(request, response);
				break;
			default:
				break;
			}
		}

		ArrayList<User> list = userDAO.selectAll();
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

		List<User> displayUserList = list.subList(start, end);
		request.setAttribute("listu", displayUserList);
		request.setAttribute("page", page);
		request.setAttribute("num", num);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ManagerUser.jsp");
		rd.forward(request, response);
	}

	private void DeleteUser(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String fail = "";
		String success = "";
		
		User u = new User();
		u.setId(Integer.parseInt(id));
		User checkUser = userDAO.selectById(u);
		
		int row = userDAO.delete(checkUser);
		
		if (row > 0) {
			success = "Xóa người dùng thành công";
			request.setAttribute("success", success);
		} else {
			fail = "Xóa người dùng thất bại";
			request.setAttribute("fail", fail);
		}
	}

	private void UpdateUser(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String birthDay = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String isAdmin = request.getParameter("isAdmin");
		String fail = "";
		String success = "";
		
		User u = new User();
		u.setId(Integer.parseInt(id));
		User checkUser = userDAO.selectById(u);
		
		checkUser.setFullName(fullname);
		
		boolean gioiTinh = gender.equals("male") ? true : false;
		checkUser.setGender(gioiTinh);
		
		checkUser.setBirthDay(Date.valueOf(birthDay));
		checkUser.setEmail(email);
		checkUser.setPhoneNumber(phoneNumber);
		checkUser.setAddress(address);
		checkUser.setUpdatedAt(Date.valueOf(LocalDate.now()));
		
		boolean quanTri = isAdmin.equals("yes") ? true : false;
		checkUser.setAdmin(quanTri);
		
		int row = userDAO.update(checkUser);
		
		if (row > 0) {
			success = "Cập nhật thông tin người dùng thành công";
			request.setAttribute("success", success);
		} else {
			fail = "Cập nhật thông tin người dùng thất bại";
			request.setAttribute("fail", fail);
		}

	}

	private void AddUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String birthDay = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String isAdmin = request.getParameter("isAdmin");
		String fail = "";
		String success = "";

		User u = new User();
		if (userDAO.checkUser(username)) {
			fail = "Tên đăng nhập đã tồn tại";
			request.setAttribute("fail", fail);
		} else {
			u.setUser(username);
			u.setPassword(password);
			u.setFullName(fullname);
			
			boolean gioiTinh = gender.equals("male") ? true : false;
			u.setGender(gioiTinh);
			
			u.setBirthDay(Date.valueOf(birthDay));
			u.setEmail(email);
			u.setPhoneNumber(phoneNumber);
			u.setAddress(address);
			u.setCreatedAt(Date.valueOf(LocalDate.now()));
			u.setUpdatedAt(Date.valueOf(LocalDate.now()));
			
			boolean quanTri = isAdmin.equals("yes") ? true : false;
			u.setAdmin(quanTri);
			
			int row = userDAO.insert(u);
			
			if (row > 0) {
				success = "Thêm người dùng thành công";
				request.setAttribute("success", success);
			} else {
				fail = "Thêm người dùng thất bại";
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
