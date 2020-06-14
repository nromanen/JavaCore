package lesson_4;
/*Solve the next tasks:
read 3 float numbers and check: are they all belong to the range [-5,5];
read 3 integer numbers and write max and min of them;
read number of HTTP Error (400, 401,402, ...) and write the name of this error
(Declare enum HTTPError)
 */


import static java.lang.System.*;
public class Operators {
    public static void main(String[] arg) {
        int q = (int) (Math.random() * 10);
        out.println(q);
        int a = q;
        int b = 5;
        int c = -5;
        int max = 5;
        int min = -5;

        if (a >= min && a <= max && b >= min && b <= max && c >= min && c <= max) {
            out.println("Дані числа лежать в діапазоні від -5 до 5");
        } else {
            out.println("Дані числа НЕ лежать в діапазоні від -5 до 5");
        }

//        int z = a < b ? (a + b) : (a - b);
//        out.println(z);

        if (a > c && a > b) {
            out.println(a + " найбільше!");
        } else if (b > a && b > c) {
            out.println(b + " найбільше!");
        } else if (c > a && c > b) {
            out.println(c + " найбільше!");
        } else {
            out.println("Найбільшого числа немає");
        }


        if (a < c && a < b) {
            out.println(a + " найменше число!");
        } else if (b < a && b < c) {
            out.println(b + " найменше число!");
        } else if (c < a && c < b) {
            out.println(c + " найменше число!");
        } else {
            out.println("Найменшого числа немає");
        }




    }
}


/*
    public static void second(String[] arg) {
     int bigger = ();
        int a = 0;
        int b = 5;
        int c = -6;
      switch (bigger){
          case (a > b):
              System.out.println(a > b);
              break;

    }
}

*/