package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import service.BlogService;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/blogs")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BlogService service = new BlogService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, List<Blog>> displayBlogs = service.getBlogToDisplay();
		List<Blog> top3Blogs = displayBlogs.get("top3");
		List<Blog> remandingBlogs = displayBlogs.get("remain");
		
		request.setAttribute("top3", top3Blogs);
		request.setAttribute("remain", remandingBlogs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BlogList.jsp");
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
