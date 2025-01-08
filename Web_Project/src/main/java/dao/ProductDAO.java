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

	public ArrayList<Product> getProductByAmountAndIndex(int amount, int index) {
		ArrayList<Product> re = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product ORDER BY id DESC LIMIT ? OFFSET ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, amount);
			st.setInt(2, (index - 1) * amount);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"),
						rs.getInt("discount"), rs.getInt("warranty"), rs.getInt("inventoryNumber"),
						rs.getString("description"), rs.getString("thumbnail"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"), rs.getInt("categoryId"), rs.getInt("numOfPur"));
				re.add(p);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<Product> getProductByCheckedCategory(int[] cid) {
		ArrayList<Product> re = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE 1=1";
			if (cid != null && cid[0] != 0) {
				sql += " AND categoryId IN(";
				for (int i = 0; i < cid.length; i++) {
					sql += cid[i] + ",";
				}
				if (sql.endsWith(",")) {
					sql = sql.substring(0, sql.length() - 1);
				}
				sql += ")";
			}
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"),
						rs.getInt("discount"), rs.getInt("warranty"), rs.getInt("inventoryNumber"),
						rs.getString("description"), rs.getString("thumbnail"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"), rs.getInt("categoryId"), rs.getInt("numOfPur"));
				re.add(p);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList<Product> getProductByPriceRange(double from, double to) {
		ArrayList<Product> re = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE price BETWEEN ? AND ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, from);
			stmt.setDouble(2, to);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery();

			// Bước 4:
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"),
						rs.getInt("discount"), rs.getInt("warranty"), rs.getInt("inventoryNumber"),
						rs.getString("description"), rs.getString("thumbnail"), rs.getDate("createdAt"),
						rs.getDate("updatedAt"), rs.getInt("categoryId"), rs.getInt("numOfPur"));
				re.add(p);
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
	
	
	public boolean deleteProductById(int id) {
	    boolean result = false;
	    try (Connection con = JDBCUtil.getConnection()) {
	        String sql = "DELETE FROM product WHERE id = ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1, id);
	        result = st.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
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
				String brand=rs.getString("brand");
				double price = rs.getDouble("price");
				int discount = rs.getInt("discount");
				int warranty = rs.getInt("warranty");
				int inventoryNumber = rs.getInt("inventoryNumber");
				String description = rs.getString("description");
				String thumbnail = rs.getString("thumbnail");
				Date createAt = rs.getDate("createdAt");
				Date updateAt = rs.getDate("updatedAt");
				int numOfPur = rs.getInt("numOfPur");

				Product p = new Product(id1, title, brand, price, discount, warranty, inventoryNumber, description, thumbnail, createAt, updateAt, cid, numOfPur);

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

	public boolean insertProduct(Product p, String image2) {
		boolean result = false;

		Connection con = null;
		PreparedStatement stProduct = null;
		PreparedStatement stImage = null;

		try {
			// Bước 1: Tạo kết nối đến CSDL
			con = JDBCUtil.getConnection();

			// Bước 2: Tắt chế độ tự động commit (bắt đầu transaction)
			con.setAutoCommit(false);

			// Bước 3: Insert vào bảng product
			String sqlProduct = "INSERT INTO product (categoryId, title, brand, price, discount, warranty, inventoryNumber, description, thumbnail, createdAt, updatedAt, numOfPur) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stProduct = con.prepareStatement(sqlProduct, PreparedStatement.RETURN_GENERATED_KEYS);

			// Gán giá trị cho các tham số
			stProduct.setInt(1, p.getCid());
			stProduct.setString(2, p.getTitle());
			stProduct.setString(3, p.getBrand());
			stProduct.setDouble(4, p.getPrice());
			stProduct.setInt(5, p.getDiscount());
			stProduct.setInt(6, p.getWarranty());
			stProduct.setInt(7, p.getInventoryNumber());
			stProduct.setString(8, p.getDescription());
			stProduct.setString(9, p.getThumbnail());
			stProduct.setDate(10, new java.sql.Date(p.getCreatedAt().getTime()));
			stProduct.setDate(11, new java.sql.Date(p.getUpdatedAt().getTime()));
			stProduct.setInt(12, p.getNumOfPur());

			// Thực thi câu lệnh insert
			int rowsInserted = stProduct.executeUpdate();

			if (rowsInserted > 0) {
				// Lấy ID của product vừa được thêm
				ResultSet rs = stProduct.getGeneratedKeys();
				if (rs.next()) {
					int productId = rs.getInt(1);

					// Bước 4: Insert vào bảng image
					String sqlImage = "INSERT INTO image (pid, image1, image2) VALUES (?, ?, ?)";
					stImage = con.prepareStatement(sqlImage);

					// Gán giá trị cho các tham số
					stImage.setInt(1, productId);
					stImage.setString(2, p.getThumbnail()); // image1 là thumbnail của product
					stImage.setString(3, image2); // image2 được truyền vào từ tham số

					// Thực thi câu lệnh insert vào bảng image
					int imageRowsInserted = stImage.executeUpdate();

					if (imageRowsInserted > 0) {
						// Commit transaction nếu cả hai bước đều thành công
						con.commit();
						result = true;
					} else {
						throw new SQLException("Failed to insert image data.");
					}
				} else {
					throw new SQLException("Failed to retrieve product ID.");
				}
			} else {
				throw new SQLException("Failed to insert product data.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// Rollback nếu có lỗi xảy ra
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
		} finally {
			try {
				// Đóng các tài nguyên
				if (stImage != null)
					stImage.close();
				if (stProduct != null)
					stProduct.close();
				if (con != null) {
					// Bật lại chế độ tự động commit
					con.setAutoCommit(true);
					con.close();
				}
			} catch (SQLException closeEx) {
				closeEx.printStackTrace();
			}
		}

		return result;
	}
	
	public boolean updateProduct(Product p) {
	    boolean result = false; // Biến để lưu trạng thái cập nhật
	    try {
	        // Bước 1: tạo kết nối đến CSDL
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: tạo ra đối tượng statement
	        String sql = "UPDATE product SET categoryId=?, title=?, brand=?, price=?, discount=?, warranty=?, inventoryNumber=?, description=?, thumbnail=?, updatedAt=? WHERE id=?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1, p.getCid());
	        st.setString(2, p.getTitle());
	        st.setString(3, p.getBrand());
	        st.setDouble(4, p.getPrice());
	        st.setInt(5, p.getDiscount());
	        st.setInt(6, p.getWarranty());
	        st.setInt(7, p.getInventoryNumber());
	        st.setString(8, p.getDescription());
	        st.setString(9, p.getThumbnail());
	        st.setDate(10, new java.sql.Date(p.getUpdatedAt().getTime()));
	        st.setInt(11, p.getId());

	        // Bước 3: thực thi câu lệnh SQL
	        System.out.println("SQL: " + sql);
	        int rowsUpdated = st.executeUpdate(); // Thực thi lệnh UPDATE

	        // Kiểm tra xem có dòng nào được cập nhật hay không
	        if (rowsUpdated > 0) {
	            result = true;
	            System.out.println("Cập nhật sản phẩm thành công.");
	        } else {
	            System.out.println("Không có sản phẩm nào được cập nhật.");
	        }

	        // Bước 5: đóng kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	
	
	
	

	public static void main(String[] args) {
		ProductDAO pd = new ProductDAO();
		ArrayList<Product> list = pd.selectFourProduct();
		for (Product product : list) {
			System.out.println(product);
		}

	}

}
