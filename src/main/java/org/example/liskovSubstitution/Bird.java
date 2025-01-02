package org.example.liskovSubstitution;

public class Bird {
    public void fly(){
        System.out.println("This Bird Flies");
    }
}
 class FlightLessBird extends  Bird{
    @Override
     public void fly(){
        System.out.println("This Bird is FlightLess..");
    }
 }
 class Eagle extends Bird{
    @Override
     public void fly(){
        System.out.println("Eagle flies sky high..");
    }
 }
 class Client{
    public static void makeBirdFly(Bird bird){
        bird.fly();
    }

     public static void main(String[] args) {
         Bird obj = new Bird();
         FlightLessBird obj2 = new FlightLessBird();
         Eagle obj3 = new Eagle();
         makeBirdFly(obj);
         makeBirdFly(obj2);
         makeBirdFly(obj3);
     }
 }