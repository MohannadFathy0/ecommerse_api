package copm.api.ECommerce.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
	 @Autowired
	 private CartRepository cartRepository;
	 
	 @GetMapping
	 public List<Cart> getAllCarts() {
		 return cartRepository.findAll();
	 }

    @GetMapping("/{id}")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return cartRepository.findById(id);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
    	
        return cartRepository.save(cart);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
        return cartRepository.findById(id).map(cart -> {
                	cart.setUserId(updatedCart.getUserId());
                	cart.setDate(updatedCart.getDate());
                	cart.setProducts(updatedCart.getProducts());
                    return cartRepository.save(cart);}).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
    	cartRepository.deleteById(id);
    }
}
