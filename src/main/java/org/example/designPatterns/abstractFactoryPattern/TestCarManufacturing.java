package org.example.designPatterns.abstractFactoryPattern;
//Car Type interfaces
interface SUV{
    void manufactureCarType();
}
interface Sedan{
    void manufactureCarType();
}
interface Hatchback{
    void manufactureCarType();
}

//Concrete Car Implementations
class TataSUV implements SUV{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Tata SUV");
    }
}
class TataSedan implements Sedan{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Tata Sedan");
    }
}
class TataHatchback implements Hatchback{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Tata Hatchback");
    }
}
class FordSUV implements SUV{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Ford SUV");
    }
}
class FordSedan implements Sedan{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Ford Sedan");
    }
}
class FordHatchback implements Hatchback{
    public void manufactureCarType(){
        System.out.println("manufacturing car type : Ford Hatchback");
    }
}

//Abstract Car Factory

interface CarFactory{
    SUV createSUV();
    Sedan createSedan();
    Hatchback createHatchback();
}
//Concrete Implementations of Abstract Car Factory
class TataCarFactory implements CarFactory{
    public SUV createSUV(){
        return new TataSUV();
    }
    public Sedan createSedan(){
        return new TataSedan();
    }
    public Hatchback createHatchback(){
        return new TataHatchback();
    }
}
class FordCarFactory implements CarFactory{
    public SUV createSUV(){
        return new FordSUV();
    }
    public Sedan createSedan(){
        return new FordSedan();
    }
    public Hatchback createHatchback(){
        return new FordHatchback();
    }
}
public class TestCarManufacturing {
    public static void main(String[] args) throws RuntimeException{
        //There is a scope for removing code redundancy below by using a method
        CarFactory carFactory = new TataCarFactory();
        SUV suv = carFactory.createSUV();
        Sedan sedan = carFactory.createSedan();
        Hatchback hatchback = carFactory.createHatchback();
        suv.manufactureCarType();
        sedan.manufactureCarType();
        hatchback.manufactureCarType();


        CarFactory carFactory2 = new FordCarFactory();
        SUV suv2 = carFactory2.createSUV();
        Sedan sedan2 = carFactory2.createSedan();
        Hatchback hatchback2 = carFactory2.createHatchback();
        suv2.manufactureCarType();
        sedan2.manufactureCarType();
        hatchback2.manufactureCarType();
    }
}
