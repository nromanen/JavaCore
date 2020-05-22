// Homework 2
// Define String variables name and address.
// Output question "What is your name?"
// Read the value name and output next question: “Where are you live, (name)?".
// Read address and write whole information.

import java.util.Scanner;

public class NameAndAdress {

    public static void main(String[] args) {

        String name;
        String adress;

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        name = scanner.nextLine();
        System.out.println("Where are you live, " + name + " ?");
        adress = scanner.nextLine();
        System.out.println("Your name: " + name +  "your adress: " + adress);

    }
}
