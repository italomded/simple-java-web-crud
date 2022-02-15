package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BDSimulator;
import model.Product;

public class ListProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BDSimulator connection = new BDSimulator();
		List<Product> productList = connection.getProductList();

		request.setAttribute("products", productList);

		return "forward:manageStock.jsp";

	}

}
