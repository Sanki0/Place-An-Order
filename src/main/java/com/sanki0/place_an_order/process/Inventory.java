package com.sanki0.place_an_order.process;

public class Inventory {
    private final int productCode;
    private int productQuantity;

    public Inventory(int productCode, int productQuantity) {
        this.productCode = productCode;
        this.productQuantity = productQuantity;
    }

    public int getProductCode() {
        return productCode;
    }

    public boolean setProductQuantity(int productQuantity) {
        if (productQuantity <= 0) {
            System.out.println("Quantity not accepted");
            return false;
        }
        this.productQuantity -= productQuantity;
        return true;
    }
}
