package org.example.designPatterns.abstractFactoryPattern;

interface Button{
    void render();
}

interface Checkbox{
    void render();
}

class WindowsButton implements Button{
    public void render(){
        System.out.println("Rendering Windows Button...");
    }
}
class WindowsCheckbox implements Checkbox{
    public void render(){
        System.out.println("Rendering Windows Checkbox..");
    }
}
class MacOsButton implements Button{
    public void render(){
        System.out.println("Rendering MacOs Button");
    }
}
class MacOsCheckbox implements Checkbox{
    public void render(){
        System.out.println("Rendering MacOs Checkbox...");
    }
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory{
    public Button createButton(){
        return new WindowsButton();
    }
    public Checkbox createCheckbox(){
        return new WindowsCheckbox();
    }
}
class MacOsFactory implements  GUIFactory{
    public Button createButton(){
        return new MacOsButton();
    }
    public Checkbox createCheckbox(){
        return new MacOsCheckbox();
    }
}
public class TestAbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory macOsFactory = new MacOsFactory();
        Button macOsButton = macOsFactory.createButton();
        Checkbox macOsCheckbox = macOsFactory.createCheckbox();
        macOsButton.render();
        macOsCheckbox.render();
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsButton.render();
        windowsCheckbox.render();
    }
}
