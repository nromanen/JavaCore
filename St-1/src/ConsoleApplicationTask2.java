//Tasks 2
// Output question “How are you?“.
// Define string variable answer. Read the value answer and output: “You are (answer)".

import java.util.Scanner;

public class ConsoleApplicationTask2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How are you?");

        String answer = scanner.nextLine();
        System.out.println("You are "+ answer);
    }
}
