package admincontroller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImageDAO;
import dao.ProductDAO;
import model.Image;
import model.Product;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProduct() {
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
		// Lấy id sản phẩm từ request
		String productId = request.getParameter("id");
		ProductDAO productDAO = new ProductDAO();
		ImageDAO imageDAO = new ImageDAO(); // DAO cho đối tượng Image
		 // Đường dẫn gốc của dự án
//	    String projectRoot = "E:\\titvltweb\\Web_Project";
	    String projectRoot="C:\\Users\\Admin\\eclipse-workspace\\Web_Project";
		try {
			// Lấy thông tin sản phẩm từ CSDL
			Product product = productDAO.getProductByID(Integer.parseInt(productId));
			if (product != null) {
				// Xóa file thumbnail của sản phẩm
				 String thumbnailPath = projectRoot + "/src/main/webapp/image/image1/" + product.getThumbnail();
				System.out.println("duong dan:"+ thumbnailPath);
				File thumbnailFile = new File(thumbnailPath);
				if (thumbnailFile.exists() && thumbnailFile.delete()) {
					System.out.println("File thumbnail " + product.getThumbnail() + " đã được xóa thành công.");
				} else {
					System.out.println("Không thể xóa file thumbnail " + product.getThumbnail());
				}

				// Lấy thông tin đối tượng Image dựa trên mã sản phẩm
				Image image = imageDAO.getProductByID(product.getId()+"");
				if (image != null) {
					// Xóa file image2 của sản phẩm
					 String image2Path = projectRoot + "/src/main/webapp/image/image2/" + image.getImage2();
					System.out.println("duong dan:"+ image2Path);
					File image2File = new File(image2Path);
					if (image2File.exists() && image2File.delete()) {
						System.out.println("File image2 " + image.getImage2() + " đã được xóa thành công.");
					} else {
						System.out.println("Không thể xóa file image2 " + image.getImage2());
					}

					// Xóa đối tượng Image khỏi CSDL
					boolean isImageDeleted = imageDAO.deleteImageById(image.getMid());
					if (!isImageDeleted) {
						request.setAttribute("fail", "Không thể xóa thông tin hình ảnh image2 trong CSDL.");
					}
				}

				// Xóa sản phẩm khỏi CSDL
				boolean isProductDeleted = productDAO.deleteProductById(product.getId());
				if (isProductDeleted) {
					request.setAttribute("success", "Sản phẩm và các hình ảnh liên quan đã được xóa thành công.");
				} else {
					request.setAttribute("fail", "Không thể xóa sản phẩm.");
				}
			} else {
				request.setAttribute("fail", "Sản phẩm không tồn tại.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("fail", "Đã xảy ra lỗi: " + e.getMessage());
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminmanagerproduct");
		rd.forward(request, response);
	}
}
