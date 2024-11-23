package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.Blog;
import model.BlogImage;

public class BlogDAO implements DAOInterface<Blog> {

	@Override
	public ArrayList<Blog> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<BlogImage> getBlogImagesById(int bid) {
		ArrayList<BlogImage> re = new ArrayList<BlogImage>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM blog_images WHERE blog_id =? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, bid);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int blogId = rs.getInt("blog_id");
				String imagePath = rs.getString("image_path");
				String caption = rs.getString("caption");
				int imageOrder = rs.getInt("image_order");
				BlogImage blogImage = new BlogImage(id, blogId, imagePath, caption, imageOrder);
				re.add(blogImage);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
	}

	@Override
	public Blog selectById(Blog b) {
		Blog re = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM blog WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, b.getId());
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int authorId = rs.getInt("author_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				String contentPath = rs.getString("content_Path");
				Date createdAt = rs.getDate("createdAt");
				boolean status = rs.getBoolean("status");
				List<BlogImage> images = getBlogImagesById(id);
				re = new Blog(id, authorId, title, description, thumbnail, contentPath, createdAt, status, images);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public List<Blog> selectTop3NewestBlog() {
		List<Blog> re = new ArrayList<Blog>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM blog WHERE status = 1 ORDER BY DESC LIMIT 3";
			PreparedStatement st = con.prepareStatement(sql);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int authorId = rs.getInt("author_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				String contentPath = rs.getString("content_Path");
				Date createdAt = rs.getDate("createdAt");
				boolean status = rs.getBoolean("status");
				List<BlogImage> images = getBlogImagesById(id);
				re.add(new Blog(id, authorId, title, description, thumbnail, contentPath, createdAt, status, images));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public List<Blog> selectRemainingBlog() {
		List<Blog> re = new ArrayList<Blog>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM blog WHERE status = 1 ORDER BY DESC OFFSET 3";
			PreparedStatement st = con.prepareStatement(sql);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int authorId = rs.getInt("author_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				String contentPath = rs.getString("content_Path");
				Date createdAt = rs.getDate("createdAt");
				boolean status = rs.getBoolean("status");
				List<BlogImage> images = getBlogImagesById(id);
				re.add(new Blog(id, authorId, title, description, thumbnail, contentPath, createdAt, status, images));
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public int insert(Blog t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Blog> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Blog t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Blog> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Blog t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
