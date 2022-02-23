package model;

public class Product {
	
	private Integer id;
	private Integer quantity;
	private String name;
	
	public Product(Integer id, String name, Integer quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public String getName() {
		return name;
	}
	
}
