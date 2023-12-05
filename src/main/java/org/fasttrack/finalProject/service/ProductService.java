package org.fasttrack.finalProject.service;

import org.fasttrack.finalProject.exception.ProductException;
import org.fasttrack.finalProject.product.Product;
import org.fasttrack.finalProject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository){this.repository=repository;}

    public List<Product> getProducts(){return repository.findAll();}

    public Product addProduct(Product product){return repository.save(product);}

    public String deleteProduct(int productId){
        repository.deleteById(productId);
        return "Deleted ID"+productId;
    }

    public Product updateProduct(Product product, int productID){
        Product product1=getByID(productID);
        if(!product.getName().isEmpty()){
            product1.setName(product.getName());
        }
        if(!product.getCompanyName().isEmpty()){
            product1.setCompanyName(product.getCompanyName());
        }
        if(product.getPrice()>0){
            product1.setPrice(product.getPrice());
        }
        if(product.getStock()>0){
            product1.setStock(product.getStock());
        }
        return product1;
    }

    public Product getByID(int productId){

        Optional<Product> product=repository.findById(productId);
        if(product.isPresent()){
            return product.get();
        }else
            throw new ProductException("Not found product with ID"+productId,productId);

    }
}
