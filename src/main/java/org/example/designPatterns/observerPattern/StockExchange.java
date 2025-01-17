package org.example.designPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
interface Observer{
    void update(String stockName,double stockPrice);
}

public class StockExchange implements Subject{
    private final List<Observer> observerList = new ArrayList<>();
    private String stockName;
    private double currentPrice;

    public void setStockPrice(String stockName, double stockPrice){
        if(!stockName.equals(this.stockName) || stockPrice!=this.currentPrice){
            this.stockName=stockName;
            this.currentPrice=stockPrice;
            notifyObserver();
        }else{
            System.out.println("No change in stockPrice for : "+stockName+ ". Observer not notified");
        }
    }

    @Override
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }
    @Override
    public void notifyObserver(){
        for(Observer obj : observerList){
            obj.update(stockName,currentPrice);
        }
    }
}

class StockApp implements  Observer{
    private final String appName;
    public StockApp(String appName){
        this.appName=appName;
    }
    @Override
    public void update(String stockName,double stockPrice){
        System.out.println(appName+" received an update." +stockName +" is now $"+stockPrice);
    }
}

class TestObserverPattern{
    public static void main(String[] args) {
        System.out.println("Welcome to Bombay Stock Exchange ............");
        //Creating a Stock Exchange
        StockExchange bombayStockExchange = new StockExchange();

        //creating observer companies
        StockApp app1 = new StockApp("Zerodha");
        StockApp app2 = new StockApp("RobinHood");

        //Registering observers

        bombayStockExchange.addObserver(app1);
        bombayStockExchange.addObserver(app2);

        //Updating stock prices or market starting today

        bombayStockExchange.setStockPrice("APPL",150.83);
        bombayStockExchange.setStockPrice("GOOGL",1290.83);

        //removing observers (or observer Companies)

        bombayStockExchange.removeObserver(app2);

        //updating stock prices again

        bombayStockExchange.setStockPrice("MSFT",280.76);
        bombayStockExchange.setStockPrice("GOOGL",1290.83);
    }
}