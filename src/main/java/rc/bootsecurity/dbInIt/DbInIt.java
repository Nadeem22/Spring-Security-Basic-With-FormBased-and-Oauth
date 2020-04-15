package rc.bootsecurity.dbInIt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInIt implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public DbInIt(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        User nadeem =new User("user",passwordEncoder.encode("user"),"USER","");
        User admin=new User("admin",passwordEncoder.encode("admin"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager=new User("manager",passwordEncoder.encode("manager"),"MANAGER","ACCESS_TEST1");
        List<User> users= Arrays.asList(nadeem,admin,manager);
        this.userRepository.saveAll(users);
    }
}
