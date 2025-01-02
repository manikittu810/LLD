package org.example.interfaceSegregation;

interface Workable{
    void work();
}
interface Eatable{
    void eat();
}
class Human implements Workable,Eatable{
    @Override
    public void work(){
        System.out.println("Humans make AI to work...");
    }
    @Override
    public void eat(){
        System.out.println("Humans should cut sugar-y food(s) from their diet..");
    }
}
class Robot implements Workable{
    @Override
    public void work(){
        System.out.println("When AI/Robots starts working, humans start to procrastinate");
    }
}
public class TestISP {
    public static void main(String[] args) {
        Human obj = new Human();
        Robot obj1 = new Robot();
        System.out.println("Humans functions : ");
        obj.work();
        obj.eat();

        System.out.println();

        System.out.println("Robot Functionalities : ");
        obj1.work();
    }
}
