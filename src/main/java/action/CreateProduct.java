package action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import factory.ConnectionFactory;

public class CreateProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramName = request.getParameter("name");
		
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.parseInt(paramQuantity);
		
		Connection con = new ConnectionFactory().getConnection();
		ProductDAO productDAO = new ProductDAO(con);
		productDAO.create(paramName, quantity);

		return "redirect:ListProduct";

	}

}
