package org.example.designPatterns.factoryDesignPattern;

public interface Notification {
    void notifyUser();
}
class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("Sending Email Notification......");
    }
}
class SMSNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("Sending SMS Notification........");
    }
}
class PushNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("Sending PushNotification.......");
    }
}
class NotificationFactory{
    public static Notification createNotification(String type){
         return switch(type.toUpperCase()){
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SMSNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type exception....");
        };
    }
}
class TestFactoryPattern{
    public static void main(String[] args) {
        Notification notification  = NotificationFactory.createNotification("email");
        notification.notifyUser();
    }
}