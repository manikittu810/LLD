package org.example.dependencyInversion;

//Abstraction
interface PaymentService{
    void processPayment();
}
//You can add many payment services as you like by extending from interface
class PayPalPayment implements PaymentService{
    @Override
    public void processPayment(){
        System.out.println("This payment is processed by PayPal");
    }
}
class StripePalPayment implements PaymentService{
    @Override
    public void processPayment(){
        System.out.println("This payment is processed by Stripe");
    }
}
class ProcessPayment{
    private final PaymentService paymentService;
    public ProcessPayment(PaymentService paymentService){
        this.paymentService= paymentService;
    }
public void process(){
    paymentService.processPayment();
    }
}
public class TestPayment {
    public static void main(String[] args) {
        PayPalPayment paypal = new PayPalPayment();
        ProcessPayment processPayment = new ProcessPayment(paypal);
        processPayment.process();

        StripePalPayment stripe = new StripePalPayment();
        ProcessPayment processPayment1 = new ProcessPayment(stripe);
        processPayment1.process();
    }
}
