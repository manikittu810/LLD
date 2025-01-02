package org.example.openClosedPrinciple;
interface Persistence{
    void save(Invoice invoice);
}

public class Invoice {
    int price;
    int tax;
    Invoice(int price , int tax){
        this.price=price;
        this.tax=tax;
    }
    public int getTotalPrice(){
        return price+tax;
    }
    public int getPrice(){
        return price;
    }
    public int getTax(){
        return  tax;
    }
}
class InvoiceDB implements Persistence{
    @Override
    public void save(Invoice invoice){
        System.out.println("Price saved to DB including tax : " +invoice.getPrice());
    }
}

class InvoiceTaxFile implements Persistence{
    @Override
    public void save(Invoice invoice){
        System.out.println("Tax applied for the price is : " +invoice.getTax());
    }
}
class InvoiceCloudStorage implements  Persistence{
    @Override
    public void save(Invoice invoice){
        System.out.println("Price of the item : " +invoice.getPrice()+" and the Tax on the item is : "+invoice.getTax()+"\n Total cost on the Item is : "+ invoice.getTotalPrice());
        System.out.println("........saving in Cloud");
    }
}
class TestOpenClosed{
    public static void main(String[] args) {
        Invoice obj = new Invoice(10,2);
        InvoiceDB obj2= new InvoiceDB();
        InvoiceTaxFile obj3 = new InvoiceTaxFile();
        InvoiceCloudStorage obj4 = new InvoiceCloudStorage();
        obj2.save(obj);
        obj3.save(obj);
        obj4.save(obj);
    }
}