package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Category;
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
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Category c = new Category();
				c.setCid(cid);
				CategoryDAO cd = new CategoryDAO();
				Category ca = cd.selectById(c);

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);
				p.setCategory(ca);
				ketQua.add(p);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<Product> selectFourProductNew() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "order BY id desc\r\n" + "LIMIT 4";
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
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public ArrayList<Product> selectFourProduct() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "LIMIT 4";
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
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public ArrayList<Product> ChiLay4SPTiepTheo(int amount) {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "ORDER BY id\r\n" + "LIMIT 4 OFFSET ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, amount);

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
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public ArrayList<Product> getProductByCID(String cid) {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "WHERE categoryId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cid);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int cid1 = rs.getInt("categoryId");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid1, numOfPur);

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

	public ArrayList<Product> searchByName(String title) {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + " WHERE title LIKE ?"; // Thêm khoảng trắng ở đây
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + title + "%");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int cid = rs.getInt("categoryId");
				String title1 = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id, title1, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public Product getProductByID(String id) {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int cid = rs.getInt("categoryId");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id1, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public Product getProductByID(int id) {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product\r\n" + "WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id1 = rs.getInt("id");
				int cid = rs.getInt("categoryId");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id1, title, price, discount, warranty, inventoryNumber, description, thumbnail,
						createAt, updateAt, cid, numOfPur);

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

	public ArrayList<Product> getListBypage(ArrayList<Product> list, int start, int end) {
		ArrayList<Product> arr = new ArrayList<Product>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public static void main(String[] args) {
		ProductDAO pd = new ProductDAO();
		ArrayList<Product> list = pd.selectFourProduct();
		for (Product product : list) {
			System.out.println(product);
		}

	}

}
