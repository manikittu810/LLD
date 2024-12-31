package org.example.designPatterns.strategyDesignPattern;

public class GoodsDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("This is a Goods Drive Strategy");
    }
}
