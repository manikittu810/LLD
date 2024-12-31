package org.example.designPatterns.strategyDesignPattern;

public class TestStrategyPattern {
    public static void main(String[] args) {
        Vehicle obj = new Car();
        obj.drive();
        Vehicle obj1 = new SportsCar();
        obj1.drive();
        Vehicle obj2 = new GoodsTruck();
        obj2.drive();
    }
}
