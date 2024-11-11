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
import model.User;

/**
 * Servlet implementation class ChangePassWord
 */
@WebServlet("/changepass")
public class ChangePassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassWord() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currPass = request.getParameter("currPass");
		String newPass = request.getParameter("newPass");
		String reNewPass = request.getParameter("renewPass");

		String fail = "";
		String success = "";

		// Kiem tra mat khau cu co giong hay khong
		HttpSession session = request.getSession();

		User us = (User) session.getAttribute("user");

		if (us == null) {
			fail = "Bạn chưa đăng nhập vào hệ thống!";
		} else {
			// Neu khach hang da dang nhap
			if (!currPass.equals(us.getPassword())) {
				fail = "Mật khẩu hiện tại không chính xác!";
			} else {
				if (!newPass.equals(reNewPass)) {
					fail = "Mật khẩu nhập lại không khớp!";
				} else {
					us.setPassword(newPass);
					UserDAO usd = new UserDAO();
					if (usd.changePassword(us)) {
						success = "Mật khẩu đã thay đổi thành công!";
					} else {
						fail = "Quá trình thay đổi mật khẩu không thành công!";
					}
				}
			}
		}
		String url = "/ChangePassWord.jsp";
		request.setAttribute("fail", fail);
		request.setAttribute("success", success);
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
