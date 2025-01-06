package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.UserDAO;
import model.User;
import util.PasswordUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String error = "";
		String url = "";
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.selectByUsername(username);
		
		if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			if(user.isAdmin()) {
				url="/admindashboard";
			}else {
				url = "/home";
			}
		} else {
			error = "Bạn nhập sai tên đăng nhập hoặc mật khẩu";
			request.setAttribute("error", error);
			request.setAttribute("username", username);
			url = "/Login.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
