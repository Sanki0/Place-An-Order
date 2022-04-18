package com.sanki0.place_an_order.steps;

import com.sanki0.place_an_order.ids.ReservedId;
import com.sanki0.place_an_order.process.Inventory;
import com.sanki0.place_an_order.process.User;

import java.util.UUID;

public class ReserveFunds implements Step {
    private final User user;
    private final Inventory inventory;
    private final ReservedId reservedId = new ReservedId();

    public ReserveFunds(User user, Inventory inventory) {
        this.user = user;
        this.inventory = inventory;

    }

    public boolean checkAmount(double amount) {
        if (!user.setReservedFunds(amount)) {
            System.out.println("Problem with checking, " +
                    "process aborted");
            return false;
        }
        return user.availableFunds() > 0;
    }

    public boolean checkCard() {
        int cardNumber = user.getCreditCard();
        if (cardNumber == 4000) {
            System.out.println("Credit card number not valid");
            return false;
        } else if (cardNumber < 4111 || cardNumber > 4222) {
            System.out.println("Credit card number out of bounds");
            return false;
        }
        return true;
    }

    public UUID getReservedId() {
        return reservedId.generateId();
    }

    @Override
    public Step nextStep() {
        return new UpdateInventory(user, inventory);
    }
}
