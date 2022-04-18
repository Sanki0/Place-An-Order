package com.sanki0.place_an_order.validation;

import com.sanki0.place_an_order.process.Inventory;
import com.sanki0.place_an_order.process.User;
import com.sanki0.place_an_order.steps.ReserveFunds;

public class ReserveValidation {

    private boolean validate;
    private String reservationCode;

    public ReserveValidation(User user, Inventory inventory, double amount) {
        ReserveFunds reserveFunds = new ReserveFunds(user, inventory);

        if (reserveFunds.checkCard() && reserveFunds.checkAmount(amount)) {
            this.validate = true;
        }
        if (validate){
            reservationCode= reserveFunds.getReservedId().toString();
            System.out.println("Fund Reserved");
        }
    }
    public boolean isValidate() {
        return validate;
    }

    public String getReservationCode() {
        return reservationCode;
    }

}
