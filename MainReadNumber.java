package Lesson8;

import java.io.IOException;
import java.util.Scanner;

public class MainReadNumber {
    public static void main(String[] args) throws IOException {
        readNumber.readNumber2();

        System.out.println("Please enter first number in range");
        Scanner number = new Scanner(System.in);
        int start = number.nextInt();
        System.out.println("Please enter second number in range");
        int end = number.nextInt();

        for (int i=0;i<10;i++);{
            try{
                System.out.println("Our range is from " + start + " to " + end + " ");
            System.out.println(readNumber.readNumber2(start,end));
        }
            catch (Exception e){
                System.out.println(e.getMessage());}
        }
    }
}
