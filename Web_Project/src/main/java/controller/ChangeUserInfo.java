package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class ChangeUserInfo
 */
@WebServlet("/changeInfo")
public class ChangeUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeUserInfo() {
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
		String fullname = request.getParameter("fullName");
		String genderString = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");

		boolean gender = true;
		if (genderString.equals("male")) {
			gender = true;
		} else if (genderString.equals("female")) {
			gender = false;
		}

		String status = "";
		String url = "";

		UserDAO userDAO = new UserDAO();

		User checkedUser = (User) request.getSession().getAttribute("user");
		if (checkedUser != null) {
			int id = checkedUser.getId();
			User u = new User(id, "", fullname, "", gender, Date.valueOf(birthday), email, phoneNumber, address, null,
					new java.util.Date(), false);
			userDAO.updateInfo(u);
			url = "/ChangeUserInfo.jsp";
			status = "Cập nhật thông tin thành công";
			User updatedUser = userDAO.selectById(u);
			request.getSession().setAttribute("user", updatedUser);
			request.getSession().setAttribute("status", status);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
