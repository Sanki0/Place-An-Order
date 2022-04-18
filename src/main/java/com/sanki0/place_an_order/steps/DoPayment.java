package com.sanki0.place_an_order.steps;

import com.sanki0.place_an_order.ids.PaymentId;
import com.sanki0.place_an_order.process.User;

import java.util.UUID;

public class DoPayment implements Step{
    private final User user;
    private PaymentId paymentId;

    public DoPayment(User user) {
        this.user = user;
    }

    public boolean makePayment() {
        user.debit();
        return true;
    }

    public UUID getPaymentId() {
        paymentId = new PaymentId();
        return paymentId.generateId();
    }

    @Override
    public Step nextStep() {
        return new GenerateOrder();
    }
}
