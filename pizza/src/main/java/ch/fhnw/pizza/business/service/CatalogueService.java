package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Catalogue;
import ch.fhnw.pizza.data.domain.Product;
import ch.fhnw.pizza.data.repository.ProductRepository;

@Service
public class CatalogueService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product addProduct(Product product) throws Exception {
        if(product.getProductName() != null) {
            if (productRepository.findByProductName(product.getProductName()) == null)
                return productRepository.save(product);
            throw new Exception("Product " + product.getProductName() + " already exists");
        }
        throw new Exception("Invalid product name ");
    }

    //Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String house) {
        String currentOffer = "No special offer";
        if("Griffindor".equalsIgnoreCase(house))
            currentOffer = "10% discount on all brooms";
        else if("Slytherin".equalsIgnoreCase(house))
            currentOffer = "15% discount on all brooms";
        else if("Hufflepuff".equalsIgnoreCase(house))
            currentOffer = "20% discount on all brooms";
        else if("Ravenclaw".equalsIgnoreCase(house))
            currentOffer = "25% discount on all brooms";
    }

    public Menu getCatalogueByHouse(String house) {
        String currentOffer = getCurrentOffer(house);
        List<Product> productList = getAllProducts();
        Catalogue catalogue = new Catalogue();
        catalogue.setProductList(productList);
        catalogue.setCurrentOffer(currentOffer);
        return Catalogue;
    }

    
}
