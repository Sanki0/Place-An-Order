package com.sanki0.place_an_order.validation;

import com.sanki0.place_an_order.process.Inventory;
import com.sanki0.place_an_order.process.User;
import com.sanki0.place_an_order.steps.UpdateInventory;

public class UpdateInventoryValidation {
    private boolean validate;

    public UpdateInventoryValidation(User user, Inventory inventory, int quantity) {
        UpdateInventory updateInventory = new UpdateInventory(user, inventory);
        if (updateInventory.checkProductCode() && updateInventory.checkQuantity(quantity)) {
            this.validate = true;
        }
        if (validate) {
            System.out.println("Inventory Updated");
        }
    }

    public boolean isValidate() {
        return validate;
    }
}
