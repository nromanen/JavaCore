    //Tasks 1
// Create Console Application project in Java.
//In method main() write code for solving next tasks:
//Define integer variables a and b. Read values a and b from Console and calculate:
//a + b
//a - b
//a * b
//a / b.
//Output obtained results.

import java.util.Scanner;

    public class ConcoleAplicationTask1 {

        public static void main(String[] args) throws InterruptedException {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter two values to gey the result");
            Thread.sleep(2000);
            System.out.println("Please, enter the first integer ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println("Please, enter the second integer ");
            int b = scanner.nextInt();
            if (b == 0) {
                System.out.println("Second integer can't be zero");

            } else {

                System.out.println("a + b = " + (a + b));
                System.out.println("a - b = " + (a - b));
                System.out.println("a * b = " + (a * b));
                System.out.println("a / b = " + (a / b));
            }
        }
    }

