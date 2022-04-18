package com.sanki0.place_an_order.steps;

import com.sanki0.place_an_order.ids.OrderId;

import java.util.UUID;

public class GenerateOrder implements Step{
    private OrderId orderId;

    public UUID getOrderId() {
        orderId= new OrderId();
        return orderId.generateId();
    }

    @Override
    public Step nextStep() {
        return null;
    }
}
