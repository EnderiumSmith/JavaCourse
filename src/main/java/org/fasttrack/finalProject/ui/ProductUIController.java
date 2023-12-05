package org.fasttrack.finalProject.ui;

import org.fasttrack.finalProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductUIController {

    private ProductService service;

    @Autowired
    public ProductUIController(ProductService service){
        this.service=service;
    }

    @GetMapping("products-app")
    String getProducts(Model model){
        model.addAttribute("products",service.getProducts());
        return "products-app";
    }
}
