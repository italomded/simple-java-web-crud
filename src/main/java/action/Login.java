package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BDSimulator;
import model.User;

public class Login implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramLogin = request.getParameter("login");
		String paramPassword = request.getParameter("password");
		
		BDSimulator connection = new BDSimulator();
		User user = connection.getUser(paramLogin, paramPassword);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);
			return "redirect:ListProduct";
		} else return "redirect:FormLogin";
		
	}

}
