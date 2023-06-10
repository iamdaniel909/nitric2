package ch.fhnw.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.CatalogueService;
import ch.fhnw.pizza.data.domain.Catalogue;
import ch.fhnw.pizza.data.domain.Product;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class PizzaApplication {

	@Autowired
	private CatalogueService catalogueService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@GetMapping(value="/")
    public String getWelcomeString() {
        
        return "Ye ole broom shoppe, welcome!";
    } 

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Product product = new Product();
		product.setProductName("Unicorn Hair Wand");
		product.setProductPrice(99);
		catalogueService.addProduct(product);

		product = new Product();
		product.setProductName("Phoenix Wand");
		product.setProductPrice(500);
		catalogueService.addProduct(product);
		
	}

}
