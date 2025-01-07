package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Email2;
import util.GenerateOTP;

/**
 * Servlet implementation class ResendOTP
 */
@WebServlet("/resendotp")
public class ResendOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResendOTP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Email");
		// Tạo thời gian hết hạn mới
		LocalDateTime newExpiryTime = LocalDateTime.now().plusMinutes(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String formattedNewExpiryTime = newExpiryTime.format(formatter);

		// Lưu lại vào session
		session.setAttribute("OTPExpiryTime", formattedNewExpiryTime);

		// Tạo OTP mới
		String newOtp = GenerateOTP.generateOTP(6);
		session.setAttribute("OTP", newOtp);
		
		Email2.sendEmail(email, "Mã OTP của bạn để xác nhận tài khoản",
				"<h1>Mã xác nhận của bạn là :" + newOtp + "<h1>");
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ConfirmOTP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
