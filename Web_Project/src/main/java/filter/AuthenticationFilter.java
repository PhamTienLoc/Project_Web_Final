package filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Order;
import model.User;

@WebFilter(filterName = "authenticationFilter", urlPatterns = { "/*" }, dispatcherTypes = { DispatcherType.REQUEST })
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);
		if (session == null) {
			session = req.getSession(true);
			res.sendRedirect("home");
			return;
		}

		String uri = req.getRequestURI();
		String method = req.getMethod();

		if (method.equalsIgnoreCase("POST")) {
			chain.doFilter(request, response);
			return;
		}
//		System.out.println("Request URI: " + uri);
		ServletContext context = req.getServletContext();
		Properties properties = (Properties) context.getAttribute("AUTHENTICATION_LIST");

		int lastIndex = uri.lastIndexOf("/");
		String resource = uri.substring(lastIndex + 1);
		String accessLevel = properties.getProperty(resource);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (accessLevel == null) {
			chain.doFilter(request, response);
			return;
		}

		if (uri.matches(".*/admin/.*") || accessLevel.equalsIgnoreCase("ADMIN")) {
			if (user == null || !user.isAdmin()) {
				res.sendError(403, "Bạn không có quyền truy cập trang này. Vui lòng liên hệ admin.");
				return;
			}
		}

		switch (accessLevel) {
		case "USER":
			if (user == null) {
				res.sendRedirect("Login.jsp");
				return;
			}
			break;
		case "CART":
			Cart cart = (session != null) ? (Cart) session.getAttribute("cart") : null;
			Order order = (session != null) ? (Order) session.getAttribute("order") : null;

			if (user == null || cart == null || cart.getItems().isEmpty()) {
				res.sendRedirect("home");
				return;
			}

			if (uri.contains("check")) {
				if (order == null) {
					order = new Order();
					session.setAttribute("order", order);
					res.sendRedirect("FormCheckOut.jsp");
					return;
				}
				break; 
			}

			if (uri.contains("confirmcheckout") && (order == null || order.getPaymentMethod() == null)) {
				res.sendRedirect("Check.jsp");
				return;
			}

			if (uri.endsWith("FormCheckOut.jsp")) {
				break;
			}

			if (order == null || order.getPaymentMethod() == null || order.getPaymentMethod().isEmpty()) {
				res.sendRedirect("Cart.jsp");
				return;
			}

			break;

		default:
			break;
		}

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
