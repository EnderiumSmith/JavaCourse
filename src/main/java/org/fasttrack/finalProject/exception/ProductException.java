package org.fasttrack.finalProject.exception;

public class ProductException extends RuntimeException{

    private int productID;

    public ProductException(String message,int productID){
        super(message);
        this.productID=productID;
    }
}
