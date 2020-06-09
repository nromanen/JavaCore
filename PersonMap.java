package Lesson6;

import java.util.HashMap;

public class PersonMap<S, S1> {

    public static void main(String[] args) {

        HashMap<String, String> persons = new HashMap<String, String>();

        persons.put("Klichko", "Vitalii");
        persons.put("Usik", "Oleksandr");
        persons.put("Klichko", "Vladimir");
        persons.put("Zelenskii", "Vladimir");
        persons.put("Timoshenko", "Yuliya");
        persons.put("Boyko", "Yurii");
        persons.put("Gagarin", "Yurii");
        persons.put("Podkopaeva", "Yuliya");
        persons.put("Trump", "Donald");
        persons.put("Duck", "Donald");

        System.out.println("Persons who in our Array is : ");

        for (String i : persons.keySet()) {
            System.out.println("LastName: " + i + " FirstName: " + persons.get(i));
        }
        persons.remove("Klichko");

        System.out.println("Sorry but Klichko brothers is out ... ");
        System.out.println("Persons who left in our Array : ");

        for (String i : persons.keySet()) {
            System.out.println("LastName: " + i + " FirstName: " + persons.get(i));


        }
    }
}


