package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BDSimulator;
import model.Product;

public class CreateProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramName = request.getParameter("name");
		
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.parseInt(paramQuantity);
		
		BDSimulator connection = new BDSimulator();
		Product product = new Product();
		product.setName(paramName);
		product.setQuantity(quantity);
		connection.create(product);

		return "redirect:ListProduct";

	}

}
