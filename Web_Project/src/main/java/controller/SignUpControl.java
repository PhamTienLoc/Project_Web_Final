package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpControl() {
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

		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String rePassword = request.getParameter("repassword");
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String birthDay = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");

		boolean gioiTinh = true;
		if (gender.equals("male")) {
			gioiTinh = true;
		} else if (gender.equals("female")) {
			gioiTinh = false;
		}
	
		String fail = "";
		String success = "";
		String url = "";
		UserDAO ud = new UserDAO();
		if (!passWord.equals(rePassword)) {
			fail = "Mật khẩu không giống mật khẩu nhập lại";
		}
		if (ud.checkUser(userName)) {
			fail = "Tên đăng nhập đã tồn tại";
		}

		if (fail.length() > 0) {
			request.setAttribute("userName", userName);
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender1", gender);
			request.setAttribute("date", birthDay);
			request.setAttribute("email", email);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("address", address);
			request.setAttribute("fail", fail);
			url = "/Signup.jsp";
		} else {
			success = "Đăng ký thành công";
			User us = new User(userName, fullName, passWord, gioiTinh, Date.valueOf(birthDay), email, phoneNumber, address, new java.util.Date(), new java.util.Date(), false);
			ud.insert(us);
			request.setAttribute("success", success);
			url = "/Signup.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);

		doGet(request, response);
	}

}
