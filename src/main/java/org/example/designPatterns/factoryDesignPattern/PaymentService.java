package org.example.designPatterns.factoryDesignPattern;

public interface PaymentService {
    void payUser();
}
class PaypalPaymentService implements PaymentService{
    @Override
    public void payUser(){
        System.out.println("Paid using PayPal payment service......");
    }
}
class StripePaymentService implements PaymentService{
    @Override
    public void payUser(){
        System.out.println("Paid using Stripe payment service...");
    }
}
class UPIService implements PaymentService{
    @Override
    public void payUser(){
        System.out.println("Paid using UPI payment service...");
    }
}
class PaymentFactory{
    public static PaymentService createPayment(int paymentOption){
        return switch(paymentOption){
            case 1 -> new PaypalPaymentService();
            case 2 -> new StripePaymentService();
            case 3-> new UPIService();
            default -> throw new IllegalArgumentException("Unknown payment service option, select a valid one...");
        };
    }
}
class TestPayment{
    public static void main(String[] args) {
        PaymentService paymentService = PaymentFactory.createPayment(1);
        paymentService.payUser();
    }
}