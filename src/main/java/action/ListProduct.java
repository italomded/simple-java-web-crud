package action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import factory.ConnectionFactory;
import model.Product;

public class ListProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = new ConnectionFactory().getConnection();
		ProductDAO productDAO = new ProductDAO(con);
		List<Product> productList = productDAO.retrieveAll();

		request.setAttribute("products", productList);

		return "forward:manageStock.jsp";

	}

}
