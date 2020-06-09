package lesson_1;
import java.util.Scanner;

public class FlaverBed {
    public static void main(String[] args) {

        System.out.println("What is radius?");
        Scanner rad = new Scanner(System.in);
        double radius = rad.nextDouble();

        double Pi = 3.14;
        double P = 2 * Pi * radius;
        double S = Pi * radius;
       // double radius = Double.parseDouble(br.readLine();

        System.out.println("Периметр складає " + P);
        System.out.println("Площа складає " + S);


    }
}