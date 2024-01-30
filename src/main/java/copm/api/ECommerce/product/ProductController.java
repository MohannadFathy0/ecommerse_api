package copm.api.ECommerce.product;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	private ProductRepository products;
	
	public ProductController(ProductRepository products) {
		super();
		this.products = products;
	}

	@GetMapping
	private Iterable<Product> retriveAllProducts (){
		return products.findAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = products.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = products.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (!products.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        product.setId(id);
        Product updatedProduct = products.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (!products.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        products.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
