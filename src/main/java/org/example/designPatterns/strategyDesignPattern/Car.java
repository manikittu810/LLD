package org.example.designPatterns.strategyDesignPattern;

// Base class for all vehicles
abstract class Vehicle {
    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

// Strategy interface for defining different driving behaviors
interface DriveStrategy {
    void drive();
}

// Concrete implementation of a normal drive strategy
class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is a normal Drive Strategy");
    }
}

// Concrete implementation of a sports drive strategy
class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is a Sports Vehicle");
    }
}

// Concrete implementation of a goods drive strategy
class GoodsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is a Goods Drive Strategy");
    }
}

// Specific vehicle types with their respective strategies
public class Car extends Vehicle {
    public Car() {
        super(new NormalDriveStrategy());
    }
}

class SportsCar extends Vehicle {
    public SportsCar() {
        super(new SportsDriveStrategy());
    }
}

class GoodsTruck extends Vehicle {
    public GoodsTruck() {
        super(new GoodsDriveStrategy());
    }
}

// Test class to demonstrate the Strategy Design Pattern
class TestStrategyPattern {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.drive();

        Vehicle sportsCar = new SportsCar();
        sportsCar.drive();

        Vehicle goodsTruck = new GoodsTruck();
        goodsTruck.drive();
    }
}
