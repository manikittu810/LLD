package org.example.designPatterns.strategyDesignPattern;

public class SportsStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("This is a Sports Vehicle");
    }
}
