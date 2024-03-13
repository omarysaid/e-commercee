package EcommerceWeb.EcommerceWeb.Services;


import EcommerceWeb.EcommerceWeb.Entity.Customer;
import EcommerceWeb.EcommerceWeb.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean checkId(Integer id){
        return customerRepository.existsById(id);
    }





    //insert customers endpoint
    public  void addCustomer(Customer customer){
        customerRepository.save(customer);
    }


    //select all Customers endpoint
    public List<Customer> selectCustomers(){
        return  customerRepository.findAll();
    }

    //select customer by id for update
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    //delete customer customers endpoint
    public  void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
