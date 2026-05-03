package com.mycompany.pethotel;

public abstract class PaymentFramework {

    protected String transactionId;
    protected double baseAmount;
    protected double discountRate;
    protected double finalAmount;
    protected boolean transactionFinalized;

    public PaymentFramework(String transactionId, double baseAmount, double discountRate) {
        this.transactionId = transactionId;
        this.baseAmount = baseAmount;
        this.discountRate = discountRate;
    }

    public void processInvoice(String customerId, double amount, double discount) {

        this.baseAmount = amount;
        this.discountRate = discount;

        applyDiscount();
        applyTax();

        finalizeTransaction();
    }

    private void applyDiscount() {
        baseAmount = baseAmount - (baseAmount * discountRate); 
    }

    private void applyTax() {
        finalAmount = baseAmount * 1.12; // 12% VAT
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public abstract boolean validatePayment();
    public abstract void finalizeTransaction();
    public abstract String getPaymentContextIssue();
}
