package com.sanki0.place_an_order.process;

public class User {
    private final int creditCard;
    private double totalFunds;
    private double reservedFunds;

    public User(int creditCard, double totalFunds) {
        this.creditCard = creditCard;
        this.totalFunds = totalFunds;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public double availableFunds() {
        return totalFunds - reservedFunds;
    }

    public boolean setReservedFunds(double reservedFunds) {
        if (reservedFunds <= 0) {
            System.out.println("Value not accepted, it should be greater than 0");
            return false;
        } else if (reservedFunds > totalFunds) {
            System.out.println("Not enough funds");
            return false;
        } else {
            this.reservedFunds = reservedFunds;
            return true;
        }
    }

    public void debit() {
        this.totalFunds = totalFunds - reservedFunds;
        this.reservedFunds = 0;
    }
}
