package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import context.JDBCUtil;
import model.Product;

public class ProductDAO implements DAOInterface<Product> {

	public ArrayList<Product> selectAll() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int cid = rs.getInt("categoryId");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");

				Product p = new Product(id, title, price, discount, inventoryNumber, description, thumbnail, cid);

				ketQua.add(p);
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
	public Product selectById(Product o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Product> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Product> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Product getProductLast() {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "ORDER BY id DESC\r\n" + "LIMIT 1;";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int cid = rs.getInt("categoryId");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");

				Product p = new Product(id, title, price, discount, inventoryNumber, description, thumbnail, cid);

				ketQua = p;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
