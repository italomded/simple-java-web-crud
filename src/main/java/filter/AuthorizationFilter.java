package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

//@WebFilter("/page") using web.xml
public class AuthorizationFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String action = httpRequest.getParameter("action");
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("loggedUser");
		
		Boolean userNotLogged = (user == null);
		Boolean protectedPage = !(action.equals("Login")) && !(action.equals("FormLogin"));
		
		if (userNotLogged && protectedPage ) {
			httpResponse.sendRedirect("page?action=FormLogin");
		} else chain.doFilter(request, response);
		
	}

}
