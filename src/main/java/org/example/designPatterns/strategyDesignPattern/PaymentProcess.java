package org.example.designPatterns.strategyDesignPattern;

public interface PaymentProcess {
    void pay();
}
abstract  class PaymentMethod{
    private final PaymentProcess paymentProcess;
    public PaymentMethod(PaymentProcess paymentProcess){
        this.paymentProcess = paymentProcess;
    }
    public void processPay(){
        paymentProcess.pay();
    }
}
class CreditCard implements PaymentProcess{
    @Override
    public void pay(){
        System.out.println("This payment has been processed through Credit Card");
    }
}
class UPI implements PaymentProcess{
    @Override
    public void pay(){
        System.out.println("This paymrnt has been processed through UPI");
    }
}
class PayPal implements PaymentProcess{
    @Override
    public void pay(){
        System.out.println("This payment has been processed through Paypal");
    }
}
class Visa extends PaymentMethod{
    public Visa(){
        super(new CreditCard());
    }
}
class PhonePe extends PaymentMethod{
    public PhonePe(){
        super(new UPI());
    }
}
class PayPalTransaction extends PaymentMethod{
    public PayPalTransaction(){
        super(new PayPal());
    }
}

class TestPayment{
    public static void main(String[] args) {
        PaymentMethod visa = new Visa();
        PaymentMethod phonePe = new PhonePe();
        PaymentMethod paypal = new PayPalTransaction();

        visa.processPay();
        phonePe.processPay();
        paypal.processPay();
    }
}