package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import service.BlogService;

/**
 * Servlet implementation class BlogDetail
 */
@WebServlet("/blogDetail")
public class BlogDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogService service = new BlogService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlogDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		Blog b = new Blog();
		b.setId(id);
		Blog checkBlog = service.findBlogById(b);
		if (checkBlog != null) {
			request.setAttribute("blog", checkBlog);
			String blogContent = service.renderBlogContent(getServletContext(), checkBlog);
			request.setAttribute("content", blogContent);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/BlogDetail.jsp");
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
