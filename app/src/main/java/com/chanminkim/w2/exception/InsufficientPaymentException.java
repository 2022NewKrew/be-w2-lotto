package com.chanminkim.w2.exception;

public class InsufficientPaymentException extends RuntimeException {
    private final int payment;
    private final int cost;

    public InsufficientPaymentException(int payment, int cost) {
        super(String.format("The payment[%d] is insufficient for the cost[%d]", payment, cost));
        this.payment = payment;
        this.cost = cost;
    }

    public int getPayment() {
        return payment;
    }

    public int getCost() {
        return cost;
    }
}
