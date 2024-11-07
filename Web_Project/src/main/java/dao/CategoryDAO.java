package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.JDBCUtil;
import model.Category;

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

				Category c = new Category(cid, cname);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Category> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
