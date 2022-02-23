package action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import factory.ConnectionFactory;
import model.Product;

public class FormUpdateProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		Connection con = new ConnectionFactory().getConnection();
		ProductDAO productDAO = new ProductDAO(con);
		Product product = productDAO.retrieve(id);

		request.setAttribute("product", product);

		return "forward:formUpdateProduct.jsp";

	}

}
