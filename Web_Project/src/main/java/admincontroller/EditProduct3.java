package admincontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ImageDAO;
import dao.ProductDAO;
import model.Image;
import model.Product;

/**
 * Servlet implementation class EditProduct3
 */
@WebServlet("/editproduct3")
public class EditProduct3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProduct3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Product product = (Product) session.getAttribute("product");
		Image image = (Image) session.getAttribute("i");

		// Đường dẫn gốc của dự án
//		String projectRoot = "E:\\titvltweb\\Web_Project"; // Thay đổi theo đường dẫn của bạn
		String projectRoot="C:\\Users\\Admin\\eclipse-workspace\\Web_Project";

		// Kiểm tra và xử lý upload file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					// Xử lý ảnh 1
					if (item.getFieldName().equals("image1") && item.getSize() > 0) {
						// Xóa ảnh cũ
						String oldImage1Path = projectRoot + "/src/main/webapp/image/image1/" + image.getImage1();
						File oldImage1File = new File(oldImage1Path);
						if (oldImage1File.exists() && oldImage1File.delete()) {
							System.out.println("Xóa ảnh cũ: " + oldImage1Path);
						}

						// Thêm ảnh mới
						String newImage1Name = generateUniqueFileName(item.getName(),
								projectRoot + "/src/main/webapp/image/image1");
						String newImage1Path = projectRoot + "/src/main/webapp/image/image1/" + newImage1Name;
						item.write(new File(newImage1Path));

						// Cập nhật trong đối tượng `image`
						product.setThumbnail(newImage1Name);
						image.setImage1(newImage1Name);
					}

					// Xử lý ảnh 2
					if (item.getFieldName().equals("image2") && item.getSize() > 0) {
						// Xóa ảnh cũ
						String oldImage2Path = projectRoot + "/src/main/webapp/image/image2/" + image.getImage2();
						File oldImage2File = new File(oldImage2Path);
						if (oldImage2File.exists() && oldImage2File.delete()) {
							System.out.println("Xóa ảnh cũ: " + oldImage2Path);
						}

						// Thêm ảnh mới
						String newImage2Name = generateUniqueFileName(item.getName(),
								projectRoot + "/src/main/webapp/image/image2");
						String newImage2Path = projectRoot + "/src/main/webapp/image/image2/" + newImage2Name;
						item.write(new File(newImage2Path));

						// Cập nhật trong đối tượng `image`
						image.setImage2(newImage2Name);
					}
				}
			}

			// Cập nhật database
			ImageDAO imageDAO = new ImageDAO();
			ProductDAO pdao = new ProductDAO();
			boolean updated = pdao.updateProduct(product);
			imageDAO.updateImage(image);
			if (updated) {
				request.setAttribute("success", "Cập nhật sản phẩm thành công.");
			} else {
				request.setAttribute("fail", "Cập nhật sản phẩm thất bại.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("fail", "Đã xảy ra lỗi: " + e.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/adminmanagerproduct");
		rd.forward(request, response);

	}

	// Hàm tạo tên file không trùng lặp
	private String generateUniqueFileName(String originalFileName, String uploadPath) {
		String baseName = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
		String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
		String uniqueFileName = originalFileName;

		File file = new File(uploadPath + File.separator + uniqueFileName);
		int counter = 1;

		while (file.exists()) {
			uniqueFileName = baseName + "_" + counter + extension;
			file = new File(uploadPath + File.separator + uniqueFileName);
			counter++;
		}

		return uniqueFileName;
	}

}
