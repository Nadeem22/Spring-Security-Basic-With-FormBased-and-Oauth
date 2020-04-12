package rc.bootsecurity.dbInIt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInIt implements CommandLineRunner {

    private UserRepository userRepository;

    public DbInIt(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User nadeem =new User("user","user","USER","");
        User admin=new User("admin","admin","ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager=new User("manager","manager","MANAGER","ACCESS_TEST1");
        List<User> users= Arrays.asList(nadeem,admin,manager);
        this.userRepository.saveAll(users);
    }
}
