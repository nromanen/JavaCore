//Homework 1
// Flower bed is shaped like a circle.
// Calculate the perimeter and area by entering the radius. Output obtained results.

import java.util.Scanner;

public class Flower {
    public static void main(String[] args) {
        final double p = 3.14;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please radius");
        double r = scanner.nextDouble();
        double l = 2*p*r;
        double s = p*r*r;
        System.out.println("Perimeter of flower: " + l +" and area: " + s);

    }
}