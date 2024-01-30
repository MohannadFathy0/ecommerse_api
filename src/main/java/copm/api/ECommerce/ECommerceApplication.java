package copm.api.ECommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import copm.api.ECommerce.cart.Cart;
import copm.api.ECommerce.cart.CartRepository;
import copm.api.ECommerce.product.Product;
import copm.api.ECommerce.product.ProductRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args); 
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products = productRepository.findAll();
		Cart cart1 = new Cart(1L, 1, products);
		cartRepository.save(cart1);
		
	}

}
