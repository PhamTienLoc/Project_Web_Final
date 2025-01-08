package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Cart;
import model.Item;
import model.Order;

public class OrderDAO implements DAOInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> ketQua = new ArrayList<Order>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM `order`";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userId");
				String fullName = rs.getString("fullname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String note = rs.getString("note");
				Date orderDate = rs.getDate("orderDate");
				String status = rs.getString("status");
				double totalMoeny = rs.getDouble("totalMoney");
				String paymentMethod = rs.getString("paymentmethod");

				Order o = new Order(id, userId, fullName, email, phoneNumber, address, note, orderDate, status,
						totalMoeny, paymentMethod);

				ketQua.add(o);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public Order selectById(Order o) {
		Order ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM `order` where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, o.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userId");
				String fullName = rs.getString("fullname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String note = rs.getString("note");
				Date orderDate = rs.getDate("orderDate");
				String status = rs.getString("status");
				double totalMoeny = rs.getDouble("totalMoney");
				String paymentMethod = rs.getString("paymentmethod");

				Order o1 = new Order(id, userId, fullName, email, phoneNumber, address, note, orderDate, status,
						totalMoeny, paymentMethod);

				ketQua =o1;

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public Order selectById(int id1) {
		Order ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM `order` where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id1);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userId");
				String fullName = rs.getString("fullname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String note = rs.getString("note");
				Date orderDate = rs.getDate("orderDate");
				String status = rs.getString("status");
				double totalMoeny = rs.getDouble("totalMoney");
				String paymentMethod = rs.getString("paymentmethod");

				Order o1 = new Order(id, userId, fullName, email, phoneNumber, address, note, orderDate, status,
						totalMoeny, paymentMethod);

				ketQua =o1;

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	
	

	@Override
	public int insert(Order t) {
		return 0;
	}

	public void addOrder(Order t, Cart cart) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();

		try (Connection con = JDBCUtil.getConnection()) {
			con.setAutoCommit(false); // Tắt auto commit để quản lý giao dịch thủ công

			String sql = "INSERT INTO `order` (userId, fullname, email, phoneNumber, address, note, orderDate, `status`, totalMoney, paymentmethod) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, 'pending', ?, ?)";
			try (PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				st.setInt(1, t.getUserId());
				st.setString(2, t.getFullName());
				st.setString(3, t.getEmail());
				st.setString(4, t.getPhoneNumber());
				st.setString(5, t.getAddress());
				st.setString(6, t.getNote());
				st.setString(7, date);
				st.setDouble(8, t.getTotalMoney());
				st.setString(9, t.getPaymentMethod());

				st.executeUpdate();

				try (ResultSet rs = st.getGeneratedKeys()) {
					if (rs.next()) {
						int oid = rs.getInt(1);

						// Thêm chi tiết đơn hàng vào bảng OrderDetail
						for (Item i : cart.getItems()) {
							String sql2 = "INSERT INTO orderdetails(orderId, productId, price, quantity, totalMoney) VALUES (?, ?, ?, ?, ?)";
							try (PreparedStatement st2 = con.prepareStatement(sql2)) {
								st2.setInt(1, oid);
								st2.setInt(2, i.getProduct().getId());
								st2.setDouble(3, i.getPrice());
								st2.setInt(4, i.getQuantity());
								st2.setDouble(5, i.getPrice() * i.getQuantity());
								st2.executeUpdate();
							}
						}
					}
				}

				con.commit(); // Commit giao dịch nếu mọi thứ thành công
			} catch (SQLException e) {
				con.rollback(); // Rollback giao dịch nếu có lỗi
				e.printStackTrace();
			} finally {
				con.setAutoCommit(true); // Đảm bảo bật lại auto commit sau khi kết thúc
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertAll(ArrayList<Order> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Order t) {
		int ketQua = 0;
		Connection con = null;

		try {
			con = JDBCUtil.getConnection();
			con.setAutoCommit(false); // Tắt auto-commit để quản lý giao dịch thủ công

			// Xóa chi tiết đơn hàng trước
			String sqlDetails = "DELETE FROM orderdetails WHERE orderId = ?";
			try (PreparedStatement stDetails = con.prepareStatement(sqlDetails)) {
				stDetails.setInt(1, t.getId());
				stDetails.executeUpdate();
			}

			// Xóa đơn hàng chính
			String sqlOrder = "DELETE FROM `order` WHERE id = ?";
			try (PreparedStatement stOrder = con.prepareStatement(sqlOrder)) {
				stOrder.setInt(1, t.getId());
				ketQua = stOrder.executeUpdate();
			}

			// Commit giao dịch nếu tất cả đều thành công
			con.commit();
			System.out.println("Bạn đã thực thi xóa đơn hàng và chi tiết của nó.");
			System.out.println("Số dòng đã bị thay đổi: " + ketQua);

		} catch (SQLException e) {
			// Đảm bảo rollback nếu có lỗi
			if (con != null) {
				try {
					con.rollback(); // Rollback giao dịch nếu có lỗi
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			// Đảm bảo đóng kết nối
			if (con != null) {
				try {
					con.close();
				} catch (SQLException closeEx) {
					closeEx.printStackTrace();
				}
			}
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Order> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Order t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Order> selectAllByUserId(int id) {
		ArrayList<Order> ketQua = new ArrayList<Order>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM `order` where userId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int oid = rs.getInt("id");
				int userId = rs.getInt("userId");
				String fullName = rs.getString("fullname");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				String note = rs.getString("note");
				Date orderDate = rs.getDate("orderDate");
				String status = rs.getString("status");
				double totalMoney = rs.getDouble("totalMoney");
				String paymentMethod = rs.getString("paymentmethod");

				Order o = new Order(oid, userId, fullName, email, phoneNumber, address, note, orderDate, status,
						totalMoney, paymentMethod);

				ketQua.add(o);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	
	
	public boolean confirmOrder(int id) {
	    Connection con = null;
	    try {
	        // Bước 1: Tạo kết nối đến CSDL
	        con = JDBCUtil.getConnection();
	        con.setAutoCommit(false); // Bắt đầu transaction

	        // Bước 2: Lấy thông tin order
	        String sqlGetOrder = "SELECT * FROM `order` WHERE id = ?";
	        PreparedStatement stGetOrder = con.prepareStatement(sqlGetOrder);
	        stGetOrder.setInt(1, id);
	        ResultSet rsOrder = stGetOrder.executeQuery();
	        if (!rsOrder.next()) {
	            // Không tìm thấy order
	            return false;
	        }

	        // Bước 3: Cập nhật trạng thái của order
	        String sqlUpdateOrderStatus = "UPDATE `order` SET status = 'confirmed' WHERE id = ?";
	        PreparedStatement stUpdateOrder = con.prepareStatement(sqlUpdateOrderStatus);
	        stUpdateOrder.setInt(1, id);
	        stUpdateOrder.executeUpdate();

	        // Bước 4: Lấy thông tin orderDetail
	        String sqlGetOrderDetail = "SELECT * FROM orderdetails WHERE orderId = ?";
	        PreparedStatement stGetOrderDetail = con.prepareStatement(sqlGetOrderDetail);
	        stGetOrderDetail.setInt(1, id);
	        ResultSet rsOrderDetail = stGetOrderDetail.executeQuery();

	        // Bước 5: Cập nhật tồn kho cho từng sản phẩm trong orderDetail
	        while (rsOrderDetail.next()) {
	            int productId = rsOrderDetail.getInt("productId");
	            int quantity = rsOrderDetail.getInt("quantity");

	            // Lấy thông tin sản phẩm
	            String sqlGetProduct = "SELECT inventoryNumber FROM product WHERE id = ?";
	            PreparedStatement stGetProduct = con.prepareStatement(sqlGetProduct);
	            stGetProduct.setInt(1, productId);
	            ResultSet rsProduct = stGetProduct.executeQuery();

	            if (rsProduct.next()) {
	                int stock = rsProduct.getInt("inventoryNumber");

	                // Kiểm tra tồn kho
	                if (stock < quantity) {
	                    throw new SQLException("Không đủ tồn kho cho sản phẩm ID: " + productId);
	                }

	                // Cập nhật số lượng tồn kho
	                int newStock = stock - quantity;
	                String sqlUpdateProductStock = "UPDATE product SET inventoryNumber = ? WHERE id = ?";
	                PreparedStatement stUpdateProductStock = con.prepareStatement(sqlUpdateProductStock);
	                stUpdateProductStock.setInt(1, newStock);
	                stUpdateProductStock.setInt(2, productId);
	                stUpdateProductStock.executeUpdate();
	            }
	        }

	        // Bước 6: Commit transaction nếu không có lỗi
	        con.commit();
	        return true;

	    } catch (SQLException e) {
	        if (con != null) {
	            try {
	                // Rollback nếu có lỗi
	                con.rollback();
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	        return false;

	    } finally {
	        if (con != null) {
	            try {
	                // Đặt lại chế độ tự động commit và đóng kết nối
	                con.setAutoCommit(true);
	                JDBCUtil.closeConnection(con);
	            } catch (SQLException closeEx) {
	                closeEx.printStackTrace();
	            }
	        }
	    }
	}
	
	
	

	// Để làm chức năng phân trang cực kì thú vị kk
	public ArrayList<Order> getListBypage(ArrayList<Order> list, int start, int end) {
		ArrayList<Order> arr = new ArrayList<Order>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

}
