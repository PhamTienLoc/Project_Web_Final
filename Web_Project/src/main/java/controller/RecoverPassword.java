package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import util.PasswordUtil;

/**
 * Servlet implementation class RecoverPassword
 */
@WebServlet("/recoverPassword")
public class RecoverPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecoverPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String error = "";
		String url = "";

		if (password != null && !password.isEmpty() && password.matches("^.{6,}$")) {
			HttpSession session = request.getSession();
			String recoverEmail = (String) session.getAttribute("recoverEmail");
			
			password = PasswordUtil.toBcrypt(password);
			
			User user = userDAO.selectByEmail(recoverEmail);
			user.setPassword(password);
			userDAO.updateUser(user);

			session.removeAttribute("recoverEmail");
			session.removeAttribute("forgotPassOTP");
			session.setAttribute("user", user);
			url = "/home";
		} else {
			error = "Mật khẩu không đủ ký tự";
			url = "ChooseNewPassword.jsp";
		}
		request.setAttribute("error", error);
		request.getRequestDispatcher(url).forward(request, response);
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
