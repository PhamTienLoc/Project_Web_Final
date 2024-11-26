package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.JDBCUtil;
import model.Discount;
import model.Product;

public class DiscountDAO implements DAOInterface<Discount> {

	@Override
	public ArrayList<Discount> selectAll() {
		ArrayList<Discount> ketQua = new ArrayList<Discount>();
		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM discount";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("name");
				double discount = rs.getDouble("discount");
				Date startDate = rs.getDate("start_date");
				Date endDate = rs.getDate("end_date");

				Discount ds = new Discount(id, title, discount, startDate, endDate);
				ketQua.add(ds);

			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<Discount> selectAllDiscountValid() {
		ArrayList<Discount> ketQua = new ArrayList<Discount>();
		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT *\r\n" + "FROM discount\r\n" + "WHERE end_date >= CURDATE()";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("name");
				double discount = rs.getDouble("discount");
				Date startDate = rs.getDate("start_date");
				Date endDate = rs.getDate("end_date");

				Discount ds = new Discount(id, title, discount, startDate, endDate);
				ketQua.add(ds);

			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public Discount getDiscountByID(String id) {
		Discount ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM discount\r\n" + "WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String title = rs.getString("name");
				double discount = rs.getDouble("discount");
				Date startDate = rs.getDate("start_date");
				Date endDate = rs.getDate("end_date");

				Discount ds = new Discount(id1, title, discount, startDate, endDate);

				ketQua = ds;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public void deleteDiscount(String did) {

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE FROM discount\r\n" + "WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, did);
			// Bước 3: thực thi câu lệnh SQL
			st.executeUpdate();
			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Discount selectById(Discount o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Discount t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Discount> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Discount t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Discount> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Discount t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		DiscountDAO d = new DiscountDAO();
		ArrayList<Discount> list = d.selectAllDiscountValid();
		for (Discount discount : list) {
			System.out.println(discount);
		}
	}

}
