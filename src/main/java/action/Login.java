package action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import factory.ConnectionFactory;
import model.User;

public class Login implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramLogin = request.getParameter("login");
		String paramPassword = request.getParameter("password");
		
		Connection con = new ConnectionFactory().getConnection();
		UserDAO userDAO = new UserDAO(con);
		User user = userDAO.validate(paramLogin, paramPassword);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", user);
			return "redirect:ListProduct";
		} else return "redirect:FormLogin";
		
	}

}
