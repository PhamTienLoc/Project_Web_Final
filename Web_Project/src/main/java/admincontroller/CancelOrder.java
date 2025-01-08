package admincontroller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;
import util.Email2;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/cancelorder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id_raw = request.getParameter("id");
		String fail = "";
		String success = "";
		int id;
		try {
			id = Integer.parseInt(id_raw);
			Order od = new Order();
			od.setId(id);
			OrderDAO oD = new OrderDAO();
			Order od1 = oD.selectById(id);
			String email = od1.getEmail();
			int ketQua = oD.delete(od);

			if (ketQua > 0) {
				success = "Bạn đã hủy đơn hàng thành công";
				Email2.sendEmail(email, "Thông báo về đơn hàng", "<h1>Xin lỗi đơn hàng của bạn đã bị hủy</h1>");
			} else {
				fail = "Hủy đơn hàng thất bại.";
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();

		}
		request.setAttribute("fail", fail);
		request.setAttribute("success", success);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminmanagerorder");
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
