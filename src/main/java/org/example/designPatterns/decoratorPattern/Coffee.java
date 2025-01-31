package org.example.designPatterns.decoratorPattern;

import java.util.Scanner;

public interface Coffee {
    String getDescription();
    double getCost();
}
class BasicCoffee implements Coffee{
    private  final String description;
    private  final double cost;
    public BasicCoffee(String description,double cost){
        this.description=description;
        this.cost = cost;
    }

    @Override
    public String getDescription(){
        return description;
    }
    @Override
    public double getCost(){
        return cost;
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String getDescription(){
        return coffee.getDescription();
    }
    @Override
    public double getCost(){
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added milk";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.50;
    }
}
class OatMilkDecorator extends CoffeeDecorator{
    public OatMilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added oat milk";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.70;
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added Sugar";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 0.25;
    }
}
class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added Whipped Cream";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.75;
    }
}
class BlueBerryDecorator extends CoffeeDecorator{
    public BlueBerryDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added Blue berry";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.25;
    }
}
class CaramelSyrupDecorator extends CoffeeDecorator{
    public CaramelSyrupDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() +", with added Caramel Syrup";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 1.85;
    }
}
class TestDecorator{
    public static void main(String[] args) {
        System.out.println("Welcome to SMK Coffee Dhukaanam :) ");

        Scanner sc = new Scanner(System.in);

        String coffeeName = sc.next();

        Coffee coffee = new BasicCoffee(coffeeName,3.25);
        System.out.println("Coffee Type : "+coffee.getDescription());
        System.out.println("Cost : $" + coffee.getCost());

//        Coffee milkDecorator = new MilkDecorator(coffee);
//        System.out.println("Coffee Type : "+milkDecorator.getDescription());
//        System.out.println("Cost : $" + milkDecorator.getCost());

        Coffee oatMilkDecorator = new OatMilkDecorator(coffee);
        System.out.println("Coffee Type : "+oatMilkDecorator.getDescription());
        System.out.println("Cost : $" + oatMilkDecorator.getCost());

//        Coffee sugarCoffee = new SugarDecorator(milkDecorator);
//        System.out.println("Coffee Type : "+sugarCoffee.getDescription());
//        System.out.println("Cost : $" + sugarCoffee.getCost());

        Coffee whipped = new WhippedCreamDecorator(oatMilkDecorator);
        System.out.println("Coffee Type : "+whipped.getDescription());
        System.out.println("Cost : $" + whipped.getCost());

        Coffee blueBerryAddon = new BlueBerryDecorator(whipped);
        System.out.println("Coffee Type : "+blueBerryAddon.getDescription());
        System.out.println("Cost : $" + blueBerryAddon.getCost());

        Coffee caramelSyrup = new CaramelSyrupDecorator(blueBerryAddon);
        System.out.println("Coffee Type : "+caramelSyrup.getDescription());
        System.out.println("Cost : $" + caramelSyrup.getCost());

    }
}
//milk type -oat milk, base -> macha - base , wrapper -> blue berry , caramel syrup