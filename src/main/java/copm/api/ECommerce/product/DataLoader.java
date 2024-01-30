package copm.api.ECommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add initial data to the products
        productRepository.save(new Product((long) 1, "IPhone15", "Some Text.", null, "Phones", 2000));
        productRepository.save(new Product((long) 2, "IPhone14", "Some Text.", null, "Phones", 1900));
        productRepository.save(new Product((long) 3, "IPhone13", "Some Text.", null, "Phones", 1800));
        // Add more products as needed
    }
}
