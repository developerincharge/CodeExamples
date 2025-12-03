package serialization;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class SerializationDemo {

    public static void main(String[] args) {
        Person person = new Person("Scott", 25);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))){
            out.writeObject(person);
            System.out.println("Object serialized to person.ser");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))){
            Person deserializedPerson = (Person)  in.readObject();
            System.out.println("Deserialized Person:  "+deserializedPerson.getClass()
                    +" Name : "+deserializedPerson.name
                    +" and the Age : "+deserializedPerson.age);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
