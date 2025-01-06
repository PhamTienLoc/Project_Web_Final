package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Category;
import model.Order;

public class CategoryDAO implements DAOInterface<Category> {

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> ketQua = new ArrayList<Category>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int cid = rs.getInt("id");
				String cname = rs.getString("name");
				String thumb = rs.getString("thumb");

				Category c = new Category(cid, cname, thumb);

				ketQua.add(c);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public Category selectById(Category o) {
		Category ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, o.getCid());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int cid = rs.getInt("id");
				String cname = rs.getString("name");
				String thumb = rs.getString("thumb");

				Category c = new Category(cid, cname, thumb);
				ketQua = c;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int deleteCategory(String cid) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE FROM category\r\n" + "WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cid);
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;

	}

	public boolean checkCategoryName(String cname) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category WHERE name=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cname);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(Category c) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO category(name,thumb)\r\n" + "VALUES (?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCname());
			st.setString(2, c.getThumb());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category c) {
		int res = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE FROM `category` WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, c.getCid());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			res = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + res + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int deleteAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category c) {
		int res = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE category SET name=?, thumb=? WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getCname());
			st.setString(2, c.getThumb());
			st.setInt(3, c.getCid());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			res = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + res + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public ArrayList<Category> getListBypage(ArrayList<Category> list, int start, int end) {
		ArrayList<Category> arr = new ArrayList<Category>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

}
