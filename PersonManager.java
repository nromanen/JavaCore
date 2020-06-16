package Lesson3;

import java.io.IOException;

public class PersonManager {

    public static void main(String[] args) throws IOException {

        Person p = Person.inputFromConsole();
        /*Person p1 = Person.inputFromConsole();
        Person p2 = Person.inputFromConsole();*/

        System.out.println( " New Person is : " + p);
        System.out.println(p.getLastName()+" has = " + p.getAge() + " years");
        System.out.println(p.getLastName()+" goes to school at " + p.howMuchAgeByYear() + " year");
        System.out.println(" ");
        System.out.println("Its a " + p.getGenderByLastName(p.getFirstName()));

    }
}
