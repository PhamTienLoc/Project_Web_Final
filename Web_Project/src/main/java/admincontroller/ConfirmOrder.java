package admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

/**
 * Servlet implementation class ConfirmOrder
 */
@WebServlet("/confirmorder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id_raw =request.getParameter("id");
		String fail = "";
		String success = "";
		int id;
		
		try {
			id =Integer.parseInt(id_raw);
			OrderDAO od = new OrderDAO();
			boolean check =od.confirmOrder(id);
			
			if(check) {
				success="Xác nhận đơn hàng thành công";
			}else {
				fail= "Đơn hàng xác nhận thất bại";
			}
			
			request.setAttribute("fail", fail);
			request.setAttribute("success", success);
			
			
			
			
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminmanagerorder");
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
