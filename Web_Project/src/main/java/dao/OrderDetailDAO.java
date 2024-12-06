package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Order;
import model.OrderDetail;
import model.Product;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {

	@Override
	public ArrayList<OrderDetail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail selectById(OrderDetail o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<OrderDetail> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<OrderDetail> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderDetail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<OrderDetail> getOrderDetailByOrderId(Order o) {
		ArrayList<OrderDetail> ketQua = new ArrayList<OrderDetail>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM orderdetails where orderId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, o.getId());
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				int orderId = rs.getInt("orderId");
				int productId = rs.getInt("productId");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				double subtoTal = rs.getDouble("totalMoney");

				ProductDAO pd = new ProductDAO();
				Product product = pd.getProductByID(productId);
				
				OrderDetail orderDetail = new OrderDetail(id, orderId, productId, price, quantity, subtoTal);
				orderDetail.setProduct(product);
				ketQua.add(orderDetail);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

}
