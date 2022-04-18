package com.sanki0.place_an_order.process;

import com.sanki0.place_an_order.steps.ReserveFunds;
import com.sanki0.place_an_order.steps.Step;

public class PlaceAnOrder {
    private Step currentStep;
    private final User user;
    private final Inventory inventory;

    public PlaceAnOrder(User user, Inventory inventory) {
        this.user = user;
        this.inventory = inventory;
    }

    public Step getCurrentStep() {
        return currentStep;
    }

    public void start() {
        currentStep = new ReserveFunds(user, inventory);
    }

    public void processed() {
        currentStep = currentStep.nextStep();
    }

}
