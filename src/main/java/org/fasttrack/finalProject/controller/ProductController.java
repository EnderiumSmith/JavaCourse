package org.fasttrack.finalProject.controller;

import org.fasttrack.finalProject.product.Product;
import org.fasttrack.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service){this.service=service;}

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PutMapping("{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int productId){
        return service.updateProduct(product,productId);
    }

    @DeleteMapping("{productId}")
    public String deleteProduct(@PathVariable int productId){
        return service.deleteProduct(productId);
    }

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable int productId){
        return service.getByID(productId);
    }

    @GetMapping("name")
    public List<Product> getByName(@RequestParam String name){
        List<Product> list=new ArrayList<>();
        for(Product product:service.getProducts()){
            if(product.getName().toLowerCase().contains(name.toLowerCase()))
                list.add(product);
        }
        return list;
    }

    @GetMapping("category")
    public List<Product> getByCategory(@RequestParam String category){
        List<Product> list=new ArrayList<>();
        for(Product product:service.getProducts()){
            if(product.getCategory().toLowerCase().contains(category.toLowerCase()))
                list.add(product);
        }
        return list;
    }

    @GetMapping("price")
    public List<Product> getByPrice(@RequestParam int maxPrice){
        List<Product> list=new ArrayList<>();
        for(Product product:service.getProducts()){
            if(product.getPrice()<=maxPrice)
                list.add(product);
        }
        return list;
    }
}
