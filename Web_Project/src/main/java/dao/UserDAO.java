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

import database.JDBCUtil;
import model.Discount;
import model.Product;
import model.User;

public class UserDAO implements DAOInterface<User> {

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM `user`";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("user");
				String fullName = rs.getString("fullname");
				String pass = rs.getString("password");
				boolean gender = rs.getBoolean("gender");
				Date birthDay = rs.getDate("birthday");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				Date createdAt = rs.getDate("createdAt");
				Date updatedAt = rs.getDate("updatedAt");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User us = new User(id, user, fullName, pass, gender, birthDay, email, phoneNumber, address, createdAt,
						updatedAt, isAdmin);
				ketQua.add(us);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override

	public User selectById(User o) {
		User ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement

			String sql = "SELECT * FROM `user` where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, o.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");

				String user = rs.getString("user");
				String fullName = rs.getString("fullname");
				String pass = rs.getString("password");
				boolean gender = rs.getBoolean("gender");
				Date birthDay = rs.getDate("birthday");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				Date createdAt = rs.getDate("createdAt");
				Date updatedAt = rs.getDate("updatedAt");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User us = new User(id, user, fullName, pass, gender, birthDay, email, phoneNumber, address, createdAt,
						updatedAt, isAdmin);
				ketQua = us;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

	public User selectByUsernameAndPassword(User u) {
		User user = null;

		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM USER WHERE USER=? AND PASSWORD=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u.getUser());
			st.setString(2, u.getPassword());

			// Bước 3: thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("user");
				String fullname = rs.getString("fullname");
				String password = rs.getString("password");
				boolean gender = rs.getBoolean("gender");
				Date birthDay = rs.getDate("birthDay");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				Date createdAt = rs.getDate("createdAt");
				Date updatedAt = rs.getDate("updatedAt");
				boolean isAmind = rs.getBoolean("isAdmin");

				user = new User(id, username, fullname, password, gender, birthDay, email, phoneNumber, address,
						createdAt, updatedAt, isAmind);

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
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

	public int updateInfo(User u) {
		int res = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE user " + " SET " + " fullname=?" + ", gender=?" + ", birthDay=?" + ", email=?"
					+ ", phoneNumber=?" + ", address=?" + ", updatedAt=?" + " WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, u.getFullName());
			st.setBoolean(2, u.isGender());
			st.setDate(3, new java.sql.Date(u.getBirthDay().getTime()));
			st.setString(4, u.getEmail());
			st.setString(5, u.getPhoneNumber());
			st.setString(6, u.getAddress());
			Timestamp updateTime = new Timestamp(u.getUpdatedAt().getTime());
			st.setTimestamp(7, updateTime);
			st.setInt(8, u.getId());
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

	public boolean changePassword(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE user " + " SET " + " password=?" + " WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getPassword());
			st.setInt(2, t.getId());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
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

		return ketQua > 0;
	}

	// Để làm chức năng phân trang cực kì thú vị kk
	public ArrayList<User> getListBypage(ArrayList<User> list, int start, int end) {
		ArrayList<User> arr = new ArrayList<User>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();

//		User u = new User("Lê Tuấn Phát", "phat21", "123", true, new Date(2003 - 1900, 01 - 1, 24),
//				"ltphat240103@gmail.com", "0935822771", "65a đường số 18", LocalDateTime.now(), null);
//		System.out.println(ud.checkUser("phat21"));
	}

}
