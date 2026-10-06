package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Product;
import za.ac.cput.communitystoremarketplace.Service.ProductService;

import java.util.List;

public class ProductController {
        private final ProductService productService;

        ProductController(ProductService productService){
            this.productService=productService;
        }
        @PostMapping("/create")
        public Product create(@RequestBody Product product){
            return productService.create(product);
        }
        @GetMapping("/read")
        public Product read(@RequestParam Long productId){
            return productService.read(productId);
        }
        @PutMapping("/update")
        public Product update(@RequestBody Product product){
            return productService.update(product);
        }
        @DeleteMapping("/delete")
        public boolean delete(@RequestParam Long productId){
            return productService.delete(productId);
        }
        List<Product>getAll(){
            return productService.getAll();
        }
}
