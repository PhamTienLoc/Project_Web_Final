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
import dao.UserDAO;
import model.Discount;
import model.User;

/**
 * Servlet implementation class AdminManagerUserControl
 */
@WebServlet("/adminmanageruser")
public class AdminManagerUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagerUserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO d = new UserDAO();
		ArrayList<User> list = d.selectAll();
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

		ArrayList<User> list1 = d.getListBypage(list, start, end);
		request.setAttribute("listu", list1);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/admin/ManagerUser.jsp");
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
