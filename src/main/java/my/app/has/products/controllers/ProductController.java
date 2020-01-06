package my.app.has.products.controllers;

import my.app.has.products.models.Product;
import my.app.has.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getList() {
        List<Product> productList = (List<Product>) productService.getList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
