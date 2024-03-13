package EcommerceWeb.EcommerceWeb.Repository;

import EcommerceWeb.EcommerceWeb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByEmail(String email);
}
