package inheritance;

class Animal {
    String name;

    public void eat(){
        System.out.println(name  + ":  Is  eating");
    }
}

class Dog extends Animal {
    public void bark(){
        System.out.println(name+" : is Barking");
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {


        Dog dog = new Dog();
        dog.name = "BUDDY";

        dog.eat();
        dog.bark();
    }
}
