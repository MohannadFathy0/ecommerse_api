package copm.api.ECommerce.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserData implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
    	User user1 = new User();
        user1.setId((long) 1);
        user1.setEmail("user1@example.com");
        user1.setUsername("user1");
        user1.setPassword("password1");
        FullName name1 = new FullName("John", "Doe");
        user1.setName(name1);
        user1.setAddress(null);
        user1.setPhone("123-456-7890");
        userRepository.save(user1);
    }
}
