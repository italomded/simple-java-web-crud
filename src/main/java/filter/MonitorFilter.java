package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

//@WebFilter("/page") using web.xml
public class MonitorFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String action = request.getParameter("action");
		long before = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		System.out.println("[Runtime] " + action + ": " + (after - before));
		
	}

}
