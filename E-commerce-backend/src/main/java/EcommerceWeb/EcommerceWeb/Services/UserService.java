package EcommerceWeb.EcommerceWeb.Services;



import EcommerceWeb.EcommerceWeb.Entity.User;
import EcommerceWeb.EcommerceWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkEmail(String email){
        return userRepository.existsByEmail(email);
    }





    //insert users endpoint
    public  void addUser(User user){
        userRepository.save(user);
    }


    //select all user endpoint
    public List<User> selectUsers(){
        return userRepository.findAll();
    }

    //select userby id for update
    public  User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    //delete user users endpoint
    public  void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
