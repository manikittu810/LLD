package org.example.designPatterns.strategyDesignPattern;

public class Car extends Vehicle{
    public Car(){
        super(new NormalDriveStrategy());
    }
}
