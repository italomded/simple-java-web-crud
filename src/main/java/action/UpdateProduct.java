package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BDSimulator;

public class UpdateProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		String paramName = request.getParameter("name");
		
		String paramQuantity = request.getParameter("quantity");
		Integer quantity = Integer.parseInt(paramQuantity);
		
		BDSimulator connection = new BDSimulator();
		connection.update(id, paramName, quantity);

		return "redirect:ListProduct";

	}

}
