package EcommerceWeb.EcommerceWeb.Repository;

import EcommerceWeb.EcommerceWeb.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public boolean existsById(Integer id);
}
