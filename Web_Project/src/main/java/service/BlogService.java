package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import dao.BlogDAO;
import model.Blog;
import model.BlogImage;

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

	public String renderBlogContent(ServletContext context, Blog b) throws IOException {
	    String blogContent = loadBlogContent(context, b.getContentPath());

	    List<BlogImage> imageList = blogDAO.getBlogImagesById(b.getId());
	    for (BlogImage blogImage : imageList) {
	        String placeHolder = "img_placeholder" + blogImage.getImageOrder();
	        String replacement = "<img src='" + blogImage.getImagePath() + "' alt='" + blogImage.getCaption()
	                            + "' class=\"img-fluid\">\r\n";
	        if (!blogImage.getCaption().isEmpty()) {
	            replacement += "<span class=\"fst-italic small text-muted\">" + blogImage.getCaption() + "</span>";
	        }
	        // Log ra trước khi thay thế
	        System.out.println("Before: " + blogContent);
	        
	        blogContent = blogContent.replace(placeHolder, replacement);
	        
	        // Log ra sau khi thay thế
	        System.out.println("After: " + blogContent);
	    }
	    return blogContent;
	}


	private String loadBlogContent(ServletContext context, String contentPath) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = context.getResourceAsStream("/" + contentPath);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}
		br.close();
		return sb.toString();
	}
	
}
