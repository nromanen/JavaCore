package Mathematics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Threenumber {
    public static void main(String[] args) throws IOException {
        BufferedReader number = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter number 1 < a < 10 = ");
        int a = Integer.parseInt(number.readLine());
        System.out.println("Please enter number 1 < b < 10 = ");
        int b = Integer.parseInt(number.readLine());
        System.out.println("Please enter number 1 < c < 10 = ");
        int c = Integer.parseInt(number.readLine());

        int f = a+b+c;
        System.out.println("a + b + c = " + f);
        int d = a+(b*c);
        System.out.println("a + (b * c) = " + d);
        int e = a*b*c;
        System.out.println("a * b * c = " + e);
        int j = (a*b)+c;
        System.out.println("(a * b) + c = " + j);

        int minimal = Math.min( Math.min(f,d), Math.min(e,j) );
        System.out.println("Minimal number is = " + minimal);
        int maximal = Math.max( Math.max(f,d), Math.max(e,j) );
        System.out.println("Maximal number is = " + maximal);
        }
    }


