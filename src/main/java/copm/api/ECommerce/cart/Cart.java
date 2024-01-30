package copm.api.ECommerce.cart;

import java.sql.Date;
import java.util.List;

import copm.api.ECommerce.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int userId;
	private Date date;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Long id, int userId, List<Product> products) {
		super();
		this.id = id;
		this.userId = userId;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
