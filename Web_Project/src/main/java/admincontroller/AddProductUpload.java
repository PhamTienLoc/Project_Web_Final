package admincontroller;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator.RequestorType;
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

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class AddProductUpload
 */
@WebServlet("/uploadfile")
public class AddProductUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductUpload() {
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
		Product p = (Product) session.getAttribute("product");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // Lưu file tạm
																							// thời
		try {
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> fileItems = fileUpload.parseRequest(request);

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					// Xử lý file từ trường "image1"
					if (fileItem.getFieldName().equals("image1")) {
						String image1Name = handleFileUpload(fileItem, "image/image1");
						p.setThumbnail(image1Name);
					}

					// Xử lý file từ trường "image2"
					if (fileItem.getFieldName().equals("image2")) {
						String image2Name = handleFileUpload(fileItem, "image/image2");
						ProductDAO pdao = new ProductDAO();
						pdao.insertProduct(p, image2Name);

					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("success", "thêm sản phẩm thành công");
		session.removeAttribute("product");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminmanagerproduct");
		rd.forward(request, response);
		
		
		
		

	}

	private String handleFileUpload(FileItem fileItem, String subFolderPath) throws Exception {
		String originalFileName = new File(fileItem.getName()).getName();
		if (originalFileName.toLowerCase().endsWith(".jpg") || originalFileName.toLowerCase().endsWith(".png")) {
			// Đường dẫn thư mục con (image1 hoặc image2)
			String projectRoot="E:\\titvltweb\\Web_Project";
			String uploadPath = projectRoot + "/src/main/webapp/" + subFolderPath;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
			}

			// Tạo tên file không trùng lặp
			String uniqueFileName = generateUniqueFileName(originalFileName, uploadPath);
			File file = new File(uploadPath + File.separator + uniqueFileName);
			fileItem.write(file);

			System.out.println("File uploaded successfully to " + subFolderPath + ": " + file.getAbsolutePath());
			return uniqueFileName; // Trả về tên file thực tế được lưu
		} else {
			throw new Exception(
					"Invalid file format for " + fileItem.getFieldName() + ". Only .jpg and .png are allowed.");
		}
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
