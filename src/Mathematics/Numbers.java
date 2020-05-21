package Mathematics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader number = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter number a = ");
        double a = Integer.parseInt(number.readLine());
        System.out.println("Please enter number b = ");
        double b = Integer.parseInt(number.readLine());
        double c = a + b;
        System.out.println("a + b = " + c);
        double d = a - b;
        System.out.println("a - b = " + d);
        double e = a * b;
        System.out.println("a * b = " + e);
        double f = a / b;
        System.out.println("a / b = " + f);

        // Second part of programm
        System.out.println("How are you ?");
        String answer = number.readLine();
        System.out.println("You are " + answer + " !!! ");
        System.out.println("Thank you for answers ! Good day ! ");

    }}
