package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Image;
import model.Product;

public class ImageDAO implements DAOInterface<Image> {

	@Override
	public ArrayList<Image> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image selectById(Image o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Image t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Image> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Image t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Image> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Image t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Image getProductByID(String pid) {
		Image ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM image\r\n" + "WHERE pid = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pid);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int mid = rs.getInt("mid");
				int pid1 = rs.getInt("pid");
				String img1 = rs.getString("image1");
				String img2 = rs.getString("image2");

				Image im = new Image(mid, pid1, img1, img2);
				ketQua = im;

			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	// Xóa Image theo id
	public boolean deleteImageById(int imageId) {
	    boolean result = false;
	    try (Connection con = JDBCUtil.getConnection()) {
	        String sql = "DELETE FROM image WHERE mid = ?";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1, imageId);
	        result = st.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	public boolean updateImage(Image image) {
	    boolean result = false;
	    try (Connection con = JDBCUtil.getConnection()) {
	        String sql = "UPDATE image SET image1 = ?, image2 = ? WHERE mid = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, image.getImage1());
	        ps.setString(2, image.getImage2());
	        ps.setInt(3, image.getMid());

	        result = ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

}
