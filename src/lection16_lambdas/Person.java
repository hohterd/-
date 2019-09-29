package lection16_lambdas;

import java.util.Comparator;

public class Person {
    String firstName;
    String lastName;

    public int getAge() {
        return age;
    }

    private int age;

    Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
