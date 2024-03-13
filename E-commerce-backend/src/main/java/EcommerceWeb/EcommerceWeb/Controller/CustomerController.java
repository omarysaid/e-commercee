package EcommerceWeb.EcommerceWeb.Controller;

import EcommerceWeb.EcommerceWeb.Entity.Customer;
import EcommerceWeb.EcommerceWeb.Entity.User;
import EcommerceWeb.EcommerceWeb.Services.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model; // Correct import statement
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    public CustomerService customerService;



    // read all customers
//    localhost:2020/customersLists
    @GetMapping("/customer")
    @ResponseBody
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> list = customerService.selectCustomers();

        // Print customer details to console
        for (Customer customer : list) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("First Name: " + customer.getFirstname());
            System.out.println("Last Name: " + customer.getLastname());
            System.out.println("Gender: " + customer.getGender());
            System.out.println("Region: " + customer.getRegion());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Password: " + customer.getPassword());
            System.out.println("-----------------------");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    // post customers endpoint
//    localhost:2020/customersSave
    @PostMapping("/customer")
    @ResponseBody
    public ResponseEntity<Customer> insertCustomers(@RequestBody Customer customer, HttpSession session) {
        System.out.println(customer);
        try {
            customerService.addCustomer(customer); // Save the customer and get the saved instance
            Customer savedCustomer = customerService.getCustomerById(customer.getId());  // Fetch the saved customer from the database
            return new ResponseEntity<>(savedCustomer, HttpStatus.OK); // Return the saved customer in the response
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

      @RequestMapping("/customer/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable("id") Long id, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer != null) {
            // Update the existing customer with new details
            existingCustomer.setFirstname(updatedCustomer.getFirstname());
            existingCustomer.setLastname(updatedCustomer.getLastname());
            existingCustomer.setGender(updatedCustomer.getGender());
            existingCustomer.setRegion(updatedCustomer.getRegion());
            existingCustomer.setPhone(updatedCustomer.getPhone());

            // Save the updated customer
            customerService.addCustomer(existingCustomer);

            return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    delete customers by id
//    localhost:2020/deleteCustomer/6
@DeleteMapping("/customer/{id}")
public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") Long id) {
    Customer existingCustomer = customerService.getCustomerById(id);

    if (existingCustomer != null) {
        customerService.deleteCustomer(id);  // Delete the customer
        System.out.println("Customer with ID " + id + " deleted successfully.");
        List<Customer> remainingCustomers= customerService.selectCustomers();
        return new ResponseEntity<>(remainingCustomers, HttpStatus.OK);
    } else {
        System.out.println("Customer with ID " + id + " not found.");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @GetMapping("/customersAccount")
    public  String CustomerAccount()
    {
        return "customersAccount";
    }
}
