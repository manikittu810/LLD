package org.example.interfaceSegregation;
class Worker implements Workable{
    @Override
    public  void work(){
        System.out.println("Work something");
    }
}
class Eater implements  Eatable{
    @Override
    public void eat(){
        System.out.println("eat something");
    }
}
//composition Impl
//Usage of composition to reduce tight coupling from inheritance
class HumanComposition{
    private  final Worker work;
    private  final Eater eat;
    HumanComposition(Worker work,Eater eat){
        this.work=work;
        this.eat= eat;
    }
    public void getWorkable(){
        work.work();
    }
    public void getEatable(){
        eat.eat();
    }
}
class RobotComposition{
    private  final Worker work;
    RobotComposition(Worker work){
        this.work=work;
    }
    public void getWorkable(){
        work.work();
    }
}
public class TestComposition {
    public static void main(String[] args) {
        Worker w = new Worker();
        Eater e = new Eater();
        HumanComposition obj2 = new HumanComposition(w,e);
        RobotComposition obj3 = new RobotComposition(w);
        System.out.println("Human Composition functions : ");
        obj2.getEatable();
        obj2.getWorkable();

        System.out.println();

        System.out.println("Robot Composition Functionalities : ");
        obj3.getWorkable();
    }
}
