package org.example.pattrernsMix;

public interface Flyable {
    void fly();
}
abstract class Bird{
    String name;
    Bird(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class FlightLess extends Bird implements Flyable{
    FlightLess(String name){
        super(name);
    }
    @Override
    public void fly(){
        System.out.println(getName() + " is FlightLess..");
    }
}
class Penguin extends FlightLess{
    Penguin(String name){
        super(name);
    }
}
class Eagle extends Bird implements Flyable{
    Eagle(String name){
        super(name);
    }
    @Override
    public void fly(){
        System.out.println(getName()+" can fly..");
    }
}
class  ClientTest{
    public static void makeBirdFly(Flyable bird){
        bird.fly();
    }

    public static void main(String[] args) {
        Flyable obj = new Penguin("Penguin");
        Flyable obj1 = new Eagle("Eagle");
        makeBirdFly(obj);
        makeBirdFly(obj1);
    }
}