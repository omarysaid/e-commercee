package EcommerceWeb.EcommerceWeb.Controller;

import EcommerceWeb.EcommerceWeb.Entity.Product;

import EcommerceWeb.EcommerceWeb.Entity.User;
import EcommerceWeb.EcommerceWeb.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    public ProductService productService;

    // get products form
    @RequestMapping("/createProd")
    public String registerPage() {
        return "register";
    }



    // read all products
    @GetMapping("/Product")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> list = productService.selectProducts();

        // Print products details to console
        for (Product product : list) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println(" Description: " + product.getDescription());
            System.out.println("discountedPrice: " + product.getDiscountedPrice());
            System.out.println("ActualPrice: " + product.getActualPrice());
            System.out.println("-----------------------");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    // post products endpoint with image upload
    @PostMapping("/Product")
    @ResponseBody
    public ResponseEntity<Product> insertUsers(@RequestBody Product product, HttpSession session) {
        System.out.println(product);
        try {
            productService.addProduct(product); // Save the user and get the saved instance
            Product savedProduct = productService.getProductById(product.getId());  // Fetch the saved user from the database
            return new ResponseEntity<>(savedProduct, HttpStatus.OK); // Return the saved user in the response
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to edit product details
    @GetMapping("/Product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {
            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to edit product details
    @PutMapping("/Product/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {
            // Update the existing product with new details
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setDiscountedPrice(updatedProduct.getDiscountedPrice());
            existingProduct.setActualPrice(updatedProduct.getActualPrice());

            // Save the updated product
            productService.addProduct(existingProduct);

            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//        delete products by id

    @DeleteMapping("/Product/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id) {
        Product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {
            productService.deleteProduct(id);  // Delete the product
            System.out.println("Product with ID " + id + " deleted successfully.");
            List<Product> remainingProducts = productService.selectProducts();
            return new ResponseEntity<>(remainingProducts, HttpStatus.OK);
        } else {
            System.out.println("Product with ID " + id + " not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productsAccount")
    public  String ProductAccount()
    {
        return "productsAccount";
    }
}
