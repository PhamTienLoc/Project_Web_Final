package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.Order;
import model.OrderDetail;
import model.User;

/**
 * Servlet implementation class ViewOrderDetailControl
 */
@WebServlet("/vieworderdetail")
public class ViewOrderDetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewOrderDetailControl() {
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
		String oid_raw = request.getParameter("id");

		int oid;
		try {

			oid = Integer.parseInt(oid_raw);
			Order o1 = new Order();
			o1.setId(oid);
			OrderDAO oD = new OrderDAO();
			Order o = oD.selectById(o1);
			OrderDetailDAO orderDetailD = new OrderDetailDAO();
			ArrayList<OrderDetail> orderDetails = orderDetailD.getOrderDetailByOrderId(o1);
			
			request.setAttribute("order",o );
			request.setAttribute("listOd", orderDetails);
			
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/OrderDetail.jsp");
			rd.forward(request, response);
			

		} catch (NumberFormatException e) {
			// TODO: handle exception
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
