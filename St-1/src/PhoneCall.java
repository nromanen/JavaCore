//Homework 3
// Phone calls from three different countries are с1, с2 and с3 standard units per minute.
// Talks continued t1, t2 and t3 minutes.
// How much computer will count for each call separately and all talk together?
// Input all source data from console, make calculations and output to the screen.

import java.util.Scanner;

public class PhoneCall {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two integer for first call:  price per minute and time talk");
        Thread.sleep(1000);
        System.out.println("Enter price fo first call:");
        double c1 = scanner.nextDouble();
        System.out.println("Enter time talk for first call:");
        double t1 = scanner.nextDouble();
        System.out.println("Enter price fo second call:");
        double c2 = scanner.nextDouble();
        System.out.println("Enter time talk for second call:");
        double t2 = scanner.nextDouble();
        System.out.println("Enter price fo third call:");
        double c3 = scanner.nextDouble();
        System.out.println("Enter time talk for third call:");
        double t3 = scanner.nextDouble();

        double p1 = c1 * t1;
        double p2 = c2 * t2;
        double p3 = c3 * c3;

        double total = p1 + p2 + p3;

        System.out.println("First call coast: " + p1 + ", second  call: " + p2 + ", third call: " + p3);

    }
}
