package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Cart;
import model.Item;
import model.Order;

public class OrderDAO implements DAOInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectById(Order o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Order t) {
		return 0;
	}

	public void addOrder(Order t, Cart cart) {
		LocalDate curDate = LocalDate.now();
		String date = curDate.toString();

		try {

			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO  `order` (userId,fullname,email,phoneNumber,address,note,orderDate,`status`,totalMoney,paymentmethod) \r\n"
					+ "VALUES(?,?,?,?,?,?,?,'pending',?,?)";
			try (PreparedStatement st = con.prepareStatement(sql)) {
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

				String sql1 = "SELECT id FROM `order` ORDER BY id DESC LIMIT 1";
				try (PreparedStatement st1 = con.prepareStatement(sql1); ResultSet rs = st1.executeQuery()) {

					if (rs.next()) {
						int oid = rs.getInt("id");
						// Thêm chi tiết đơn hàng vào bảng OrderDetail
						for (Item i : cart.getItems()) {
							String sql2 = "INSERT INTO orderdetails(orderId, productId, price, quantity,totalMoney) VALUES (?, ?, ?, ?,?)";
							try (PreparedStatement st2 = con.prepareStatement(sql2)) {
								st2.setInt(1, oid);
								st2.setInt(2, i.getProduct().getId());
								st2.setDouble(3, i.getPrice());
								st2.setInt(4, i.getQuantity());
								st2.setDouble(5, i.getPrice() * i.getQuantity());
								st2.executeUpdate();

							}

							// Cập nhập số lượng
							String sql3 = "UPDATE product SET inventoryNumber = inventoryNumber - ?, numOfPur = numOfPur + 1 WHERE id = ?";
							try (PreparedStatement st3 = con.prepareStatement(sql3)) {
								st3.setInt(1, i.getQuantity());
								st3.setInt(2, i.getProduct().getId());
								st3.executeUpdate();
							}

						}

					}

				}

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
		// TODO Auto-generated method stub
		return 0;
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

}
