package org.example.designPatterns.strategyDesignPattern;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("This is a normal Drive Strategy");
    }
}
