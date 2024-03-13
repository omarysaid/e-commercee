package EcommerceWeb.EcommerceWeb.Controller;

import EcommerceWeb.EcommerceWeb.Entity.Product;
import EcommerceWeb.EcommerceWeb.Entity.User;
import EcommerceWeb.EcommerceWeb.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    public UserService userService;


    // get users form
    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    // get Login form
    @RequestMapping("/login")
    public String loginPage()  {
        return "login";
    }

    // read all users
    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<List<User>> getAllCustomers() {

        List<User> list = userService.selectUsers();

        // Print customer details to console
        for (User  user : list) {
            System.out.println("User ID: " + user.getId());
            System.out.println("First Name: " + user.getFirstname());
            System.out.println("Last Name: " + user.getLastname());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            System.out.println("-----------------------");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    // post users endpoint
    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<User> insertUsers(@RequestBody User user, HttpSession session) {
        System.out.println(user);
        try {
            userService.addUser(user); // Save the user and get the saved instance
            User savedUser = userService.getUserById(user.getId());  // Fetch the saved user from the database
            return new ResponseEntity<>(savedUser, HttpStatus.OK); // Return the saved user in the response
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/user/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            // Update the existing user with new details
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            // Save the updated user
            userService.addUser(existingUser);

            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") Long id) {
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            userService.deleteUser(id);  // Delete the product
            System.out.println("User with ID " + id + " deleted successfully.");
            List<User> remainingUsers= userService.selectUsers();
            return new ResponseEntity<>(remainingUsers, HttpStatus.OK);
        } else {
            System.out.println("User with ID " + id + " not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/usersAccount")
    public  String UserAccount()
    {
        return "usersAccount";
    }
}
