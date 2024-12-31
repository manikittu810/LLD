package org.example.singleResponsibility;

import java.util.*;
//SRP :  a class should have one reason to change
public class Product {
    private  String name;
    private  String color;
    private int price;
    public Product(String name, String color, int price){
        this.name= name;
        this.color= color;
        this.price = price;
    }
    public Product(){}
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setPrice(int price){
        this.price= price;
    }
    public String getName(){
        return  name;
    }
    public String getColor(){
        return color;
    }
    public int getPrice(){
        return price;
    }
    @Override
    public String toString() {
        return "Product : {" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this== o){
            return false;// Step 1: Check if both references point to the same object in memory.
        }
        if(o==null || getClass()!=o.getClass()){
            return false;// Step 2: Check for null and ensure both objects are of the same class.
        }
        Product product = (Product) o;// Step 3: Cast 'o' to a Product object.
        return price == product.price &&
                Objects.equals(name,product.name) &&
                Objects.equals(color,product.color);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,color,price);
    }
}
class SaveToDB{
   private Set<Product> productSet = new HashSet<>();

   public boolean save(Product product){
       return productSet.add(product);
   }
   public Set<Product> getProductSet(){
       return productSet;
   }
}
class DBPrinter{
    public void printDBView(Set<Product> productSet){
        for(Product product : productSet){
            System.out.println(product);
        }
    }
}
class GenerateInvoice {
    private int quantity;

    public GenerateInvoice() {
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int calculateTotalWholeSaleCost(Product product, int quantity) {
        System.out.print("This is the WholeSale price for the given quantity " + quantity+" is : ");
        return product.getPrice() * quantity;
    }
}
class TestProduct{
    public static void main(String[] args) {
        Set<Product> objList = new HashSet<>();
         SaveToDB saveToDB = new SaveToDB();
        DBPrinter dbPrinter = new DBPrinter();
        GenerateInvoice generateInvoice = new GenerateInvoice();


         objList.add(new Product("Cello","Blue",5));
        objList.add(new Product("Ball pen","Red",6));
        for(Product obj1 : objList){
            System.out.println(obj1);
        }

        saveToDB.save(new Product("Cello","Blue",5));
        saveToDB.save(new Product("Ball pen","Red",6));

        System.out.println(generateInvoice.calculateTotalWholeSaleCost(new Product("Cello","Blue",5),5));
        System.out.println(generateInvoice.calculateTotalWholeSaleCost(new Product("Ball pen","Red",6),6));
        dbPrinter.printDBView(saveToDB.getProductSet());
        //you can use hashCode and equals functions here, but I'm skipping to use.
    }
}

