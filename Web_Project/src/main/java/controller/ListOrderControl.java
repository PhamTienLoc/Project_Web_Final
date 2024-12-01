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
import model.Order;
import model.User;

/**
 * Servlet implementation class ListHoaDonControl
 */
@WebServlet("/listhoadon")
public class ListOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrderControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us ==null) {
			us = new User();
		}
		OrderDAO od = new OrderDAO();
		ArrayList<Order> list = od.selectAllByUserId(us.getId());
		int page, numperpage = 5;
		int size = list.size();
		int num = (size % numperpage == 0 ? (size / numperpage) : ((size / numperpage) + 1));// số trang
		
		String xpage = request.getParameter("page");

		if (xpage == null) {
			page = 1;
		} else {
			page = Integer.parseInt(xpage);
		}
		
		int start, end;
		start = (page - 1) * numperpage;
		end = Math.min(page * numperpage, size);
		
		ArrayList<Order> list1 = od.getListBypage(list, start, end);
		
		request.setAttribute("listo", list1);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListOrder.jsp");
        rd.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
