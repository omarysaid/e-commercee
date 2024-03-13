package EcommerceWeb.EcommerceWeb.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Entity
@Data
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(nullable=false)
    private  String firstname;

    @Column(nullable=false)
    private  String lastname;

    @Column(nullable=false)
    private  String username;


    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;

}
