package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet("/page")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");
		Action action;
		
		try {
			Class paramClass = Class.forName("action."+paramAction);
			action = (Action) paramClass.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String returnParam = action.go(request, response);
		String[] methodAndMapping = returnParam.split(":");
		if (methodAndMapping[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + methodAndMapping[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("page?action=" + methodAndMapping[1]);
		}
		
	}

}
