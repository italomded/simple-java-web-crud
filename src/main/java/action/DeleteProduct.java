package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BDSimulator;
import model.Product;

public class DeleteProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		BDSimulator connection = new BDSimulator();
		Product product = connection.retrieve(id);
		connection.delete(product);

		return "redirect:ListProduct";

	}

}
