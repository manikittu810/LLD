package org.example.designPatterns.decoratorPattern;

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
class TestDecorator{
    public static void main(String[] args) {
        System.out.println("Welcome to SMK Coffee Dhukaanam :) ");
        Coffee coffee = new BasicCoffee("Pike Roast",3.25);
        System.out.println("Coffee Type : "+coffee.getDescription());
        System.out.println("Cost : $" + coffee.getCost());

        Coffee milkDecorator = new MilkDecorator(coffee);
        System.out.println("Coffee Type : "+milkDecorator.getDescription());
        System.out.println("Cost : $" + milkDecorator.getCost());

        Coffee sugarCoffee = new SugarDecorator(milkDecorator);
        System.out.println("Coffee Type : "+sugarCoffee.getDescription());
        System.out.println("Cost : $" + sugarCoffee.getCost());

        Coffee whipped = new WhippedCreamDecorator(sugarCoffee);
        System.out.println("Coffee Type : "+whipped.getDescription());
        System.out.println("Cost : $" + whipped.getCost());
    }
}