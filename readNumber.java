package Lesson8;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class readNumber {

    public static int readNumber2(int start,int end) throws IOException {

        Scanner s = new Scanner(System.in);
        System.out.println("Please write number");
        try{
            int x =s.nextInt();
            if( x>end || x<start ) {
                throw new IOException("The number is not in range");
                }
            return x;}
            catch(NumberFormatException | InputMismatchException e) {
            throw new   IOException();
        }

    }

    public static void readNumber2() {
    }
}