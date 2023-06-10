package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.CatalogueService;
import ch.fhnw.pizza.data.domain.Catalogue;
import ch.fhnw.pizza.data.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping(path="/product/{id}", produces = "application/json")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        try{
            Product product = catalogueService.findProductById(id);
            return ResponseEntity.ok(product);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path="/product", produces = "application/json")
    public List<Product> getProuctList() {
        List<Product> productList = catalogueService.getAllProducts();

        return productList;
    }

    @PostMapping(path="/product", consumes="application/json", produces = "application/json")
    public ResponseEntity addProduct(@RequestBody Product product) {
        try{
            product = catalogueService.addProduct(product);
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
        return ResponseEntity.ok(product);
        
    }

    @GetMapping(path="", produces = "application/json")
    public Catalogue getCatalogue(@RequestParam(value="house") String house) {

        return catalogueService.getCatalogueByHouse(house);
    }
    
}
