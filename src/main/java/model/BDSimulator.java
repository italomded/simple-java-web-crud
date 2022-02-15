package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BDSimulator {
	
	private static List<Product> productList = new ArrayList<>();
	private static List<User> userList = new ArrayList<>();
	private static Integer idSerial = 0;
	
	static {
		
		BDSimulator.idSerial++;
		Product product = new Product();
		product.setName("Nescau");
		product.setQuantity(12);
		product.setId(BDSimulator.idSerial);
		
		BDSimulator.idSerial++;
		Product product2 = new Product();
		product2.setName("Nutella");
		product2.setQuantity(53);
		product2.setId(BDSimulator.idSerial);
		
		productList.add(product);
		productList.add(product2);
		
		User user = new User();
		user.setLogin("admin");
		user.setPassword("admin");
		BDSimulator.userList.add(user);
		
	}
	
	public List<Product> getProductList() {
		return BDSimulator.productList;
	}
	
	public void create(Product product) {
		BDSimulator.idSerial++;
		product.setId(BDSimulator.idSerial);
		BDSimulator.productList.add(product);
	}
	
	public Product retrieve(Integer id) {
		for (Product product : BDSimulator.productList) {
			if (product.getId() == id) return product;
		} return null;
	}
	
	public void update(Integer id, String name, Integer quantity) {
		Product product = retrieve(id);
		product.setName(name);
		product.setQuantity(quantity);
	}
	
	public void delete(Product product) {
		Iterator<Product> i = BDSimulator.productList.iterator();
		while (i.hasNext()) {
			Product listProduct = i.next();
			if (listProduct.getId() == product.getId()) {
				i.remove();
				return;
			}
		}
	}
	
	public User getUser(String login, String password) {
		for (User user : BDSimulator.userList) {
			if (user.validate(login, password)) return user;
		} return null;
	}

}
