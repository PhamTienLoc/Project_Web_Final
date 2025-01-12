package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import util.Email2;
import util.GenerateOTP;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String recoverEmail = request.getParameter("recoverEmail");
		String error = "";
		String url = "";
		if (recoverEmail != null && !recoverEmail.isEmpty()) {
			if (userDAO.checkEmail(recoverEmail)) {
				HttpSession session = request.getSession();
				session.setAttribute("recoverEmail", recoverEmail);

				String forgotPassOTP = GenerateOTP.generateOTP(6);
				session.setAttribute("forgotPassOTP", forgotPassOTP);

				url = "ConfirmRecoverEmail.jsp";

				Email2.sendEmail(recoverEmail, forgotPassOTP + " là mã đặt lại mật khẩu của bạn",
					    "<h1>Thêm một bước nữa để đổi mật khẩu của bạn</h1>\n"
					    + "<p>Chúng tôi đã nhận được yêu cầu đổi mật khẩu của bạn.</p>\n"
					    + "<p>Bạn có thể nhập mã này vào để thay đổi mật khẩu: " + forgotPassOTP + "</p>\n");

			} else {
				error = "Email không tồn tại trong hệ thống!";
				url = "ForgotPassword.jsp";
			}
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
