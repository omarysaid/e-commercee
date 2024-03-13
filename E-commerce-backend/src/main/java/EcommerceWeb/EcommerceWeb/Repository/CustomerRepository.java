package EcommerceWeb.EcommerceWeb.Repository;


import EcommerceWeb.EcommerceWeb.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public boolean existsById(Integer id);
}
