package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Email2;

/**
 * Servlet implementation class SubmitContact
 */
@WebServlet("/submitcontact")
public class SubmitContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitContact() {
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

		String fail = "";
		String success = "";
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		String mailManager = "ltphat240103@gmail.com";

		// Xây dựng nội dung email
		String emailBody = "<h2>Vấn đề khách hàng</h2>" + "<p><strong>Người gửi:</strong> " + name + "</p>"
				+ "<p><strong>Email:</strong> " + email + "</p>" + "<hr>" + "<h3>Nội dung:</h3>" + "<p>" + message
				+ "</p>";

		try {
			// Gửi email
			Email2.sendEmail(mailManager, "Câu hỏi khách hàng", emailBody);
			success = "Gửi email thành công!";
			request.setAttribute("success", success);
		} catch (Exception e) {
			fail = "Gửi email thất bại. Vui lòng thử lại sau.";
			request.setAttribute("fail", fail);
		}

		// Chuyển hướng đến trang Contact
		request.getRequestDispatcher("/Contact.jsp").forward(request, response);
	}

}
