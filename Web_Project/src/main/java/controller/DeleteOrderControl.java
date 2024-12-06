package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Order;
import model.User;

/**
 * Servlet implementation class DeleteOrderControl
 */
@WebServlet("/deledeorder")
public class DeleteOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteOrderControl() {
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
		User us = (User) session.getAttribute("user");

		String oid_raw = request.getParameter("oid");
		String fail = "";
		String success = "";
		int id;
		try {
			id = Integer.parseInt(oid_raw);
			Order od = new Order();
			od.setId(id);
			OrderDAO oD = new OrderDAO();
			int ketQua = oD.delete(od);
			if (ketQua > 0) {
				success = "Bạn đã hủy đơn hàng thành công";

			} else {
				fail = "Bạn đã hủy đơn hàng thất bại";
			}
			request.setAttribute("fail", fail);
			request.setAttribute("success", success);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listhoadon");
			rd.forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
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
