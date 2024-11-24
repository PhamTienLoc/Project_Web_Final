package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BlogDAO;
import model.Blog;

public class BlogService {
	private BlogDAO blogDAO = new BlogDAO();

	public Map<String, List<Blog>> getBlogToDisplay() {
		Map<String, List<Blog>> re = new HashMap<>();
		List<Blog> top3Blogs = blogDAO.selectTop3NewestBlog();
		List<Blog> remandingBlogs = blogDAO.selectRemainingBlog();
		re.put("top3", top3Blogs);
		re.put("remain", remandingBlogs);
		return re;
	}

	public Blog findBlogById(Blog b) {
		return blogDAO.selectById(b);
	}
	
	public void renderBlogContent(Blog b) {
		
	}
}
