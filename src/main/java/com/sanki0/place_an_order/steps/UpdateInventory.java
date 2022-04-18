package com.sanki0.place_an_order.steps;

import com.sanki0.place_an_order.process.Inventory;
import com.sanki0.place_an_order.process.User;

public class UpdateInventory implements Step{
    private final User user;
    private final Inventory inventory;

    public UpdateInventory(User user, Inventory inventory) {
        this.user = user;
        this.inventory = inventory;
    }

    public boolean checkProductCode() {
        int productCode = inventory.getProductCode();
        if (productCode >= 239 && productCode <= 384) {
            System.out.println("Product code not valid");
            return false;
        }
        return true;
    }

    public boolean checkQuantity(int quantity) {
        return inventory.setProductQuantity(quantity);
    }

    @Override
    public Step nextStep() {
        return new DoPayment(user);
    }
}
