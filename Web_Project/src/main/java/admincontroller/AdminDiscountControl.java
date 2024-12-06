package admincontroller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscountDAO;
import model.Discount;

/**
 * Servlet implementation class AdminDiscountControl
 */
@WebServlet("/admindiscount")
public class AdminDiscountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDiscountControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DiscountDAO d = new DiscountDAO();
		ArrayList<Discount> list = d.selectAll();
		int page, numperpage = 7;
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

		ArrayList<Discount> list1 = d.getListBypage(list, start, end);
		Date currentDate = new Date();
		request.setAttribute("currentDate", currentDate);
		request.setAttribute("listd", list1);
		request.setAttribute("page", page);
		request.setAttribute("num", num);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ManagerDiscount.jsp");
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
