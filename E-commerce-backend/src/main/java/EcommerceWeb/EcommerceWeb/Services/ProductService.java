package EcommerceWeb.EcommerceWeb.Services;


import EcommerceWeb.EcommerceWeb.Entity.Product;
import EcommerceWeb.EcommerceWeb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean checkId(Long id){
        return productRepository.existsById(id);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> selectProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

