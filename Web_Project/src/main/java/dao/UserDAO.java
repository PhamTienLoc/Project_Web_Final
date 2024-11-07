package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import context.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(User o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO user(fullname,user,password,gender,birthday,email,phoneNumber,address,createdAt,updatedAt,isAdmin)\r\n"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,0)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullName());
			st.setString(2, t.getUser());
			st.setString(3, t.getPassword());
			st.setBoolean(4, t.isGender());
			st.setDate(5, new java.sql.Date(t.getBirthDay().getTime()));
			st.setString(6, t.getEmail());
			st.setString(7, t.getPhoneNumber());
			st.setString(8, t.getAddress());
			st.setDate(9, new java.sql.Date(t.getCreatedAt().getTime()));
			st.setDate(10, new java.sql.Date(t.getUpdatedAt().getTime()));

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
	public int insertAll(ArrayList<User> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<User> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean checkUser(String tenDangNhap) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM user WHERE user=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);

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

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();

//		User u = new User("Lê Tuấn Phát", "phat21", "123", true, new Date(2003 - 1900, 01 - 1, 24),
//				"ltphat240103@gmail.com", "0935822771", "65a đường số 18", LocalDateTime.now(), null);
		System.out.println(ud.checkUser("phat21"));
	}

}
