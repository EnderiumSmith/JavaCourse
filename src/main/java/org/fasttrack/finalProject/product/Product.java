package org.fasttrack.finalProject.product;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productID;

    private String name;
    private String companyName;
    private int price;
    private int stock;
    private String category;

    public Product(int productID,String name,String companyName, String category, int price,int stock){
        this.productID=productID;
        this.name=name;
        this.companyName=companyName;
        this.category=category;
        this.price=price;
        this.stock=stock;
    }

    public Product(){}

    public int getProductID(){return productID;}
    public void setProductID(int ProductId){productID=productID;}
    public int getPrice(){return price;}
    public void setPrice(int price){this.price=price;}
    public int getStock(){return stock;}
    public void setStock(int stock){this.stock=stock;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getCompanyName(){return companyName;}
    public void setCompanyName(String companyName){this.companyName=companyName;}
    public String getCategory(){return category;}
    public void setCategory(String category){this.category=category;}

}
