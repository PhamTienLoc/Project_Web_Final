package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class ConfirmOTP
 */
@WebServlet("/confirmotp")
public class ConfirmOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmOTP() {
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
		String url = "";
		String otpConfirm = request.getParameter("otp");
		UserDAO ud = new UserDAO();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Email");
		String otp = (String) session.getAttribute("OTP");
		// Lấy giá trị từ session
		String otpExpiryTime = (String) session.getAttribute("OTPExpiryTime");

		if (otpExpiryTime != null) {
			// Định dạng thời gian giống như lúc lưu
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

			// Chuyển đổi chuỗi thành LocalDateTime
			LocalDateTime expiryTime = LocalDateTime.parse(otpExpiryTime, formatter);
			LocalDateTime now = LocalDateTime.now();

			// So sánh thời gian hiện tại với thời gian hết hạn
			if (now.isAfter(expiryTime)) {
				fail = "Mã OTP đã hết hạn. Vui lòng yêu cầu gửi lại mã mới.";
				url = "/AgainOTP.jsp";
			} else {
				// Xử lý khi OTP chưa hết hạn
				if (otpConfirm != null && otpConfirm.equals(otp)) {
					User user = ud.selectByEmail(email);
					user.setConfirmEmail(true);
					ud.updateUser(user);

					session.removeAttribute("OTP");
					session.removeAttribute("Email");
					session.removeAttribute("OTPExpiryTime");
					url = "/SuccessConfirmEmail.jsp"; // Điều hướng đến trang thành công
				} else {
					fail = "Mã OTP không chính xác.";
					url = "/AgainOTP.jsp";
				}
			}
		}

		request.setAttribute("fail", fail);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
