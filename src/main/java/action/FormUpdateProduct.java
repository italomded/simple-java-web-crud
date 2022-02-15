package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BDSimulator;
import model.Product;

public class FormUpdateProduct implements Action {

	@Override
	public String go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		BDSimulator connection = new BDSimulator();
		Product product = connection.retrieve(id);

		request.setAttribute("product", product);

		return "forward:formUpdateProduct.jsp";

	}

}
