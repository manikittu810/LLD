package org.example.designPatterns.strategyDesignPattern;

public class GoodsTruck extends Vehicle{
    public GoodsTruck(){
        super(new GoodsDriveStrategy());
    }
}
