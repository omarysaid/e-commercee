package EcommerceWeb.EcommerceWeb.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Entity
@Data
@Table(name="customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(nullable=false)
    private  String firstname;


    @Column(nullable=false)
    private  String lastname;

    @Column(nullable=false)
    private  String gender;

    @Column(nullable=false)
    private  String region;

    @Column(nullable=false)
    private  String phone;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;

}
