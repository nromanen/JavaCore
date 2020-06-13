package lesson_4;
/*Solve the next tasks:
read 3 float numbers and check: are they all belong to the range [-5,5];
read 3 integer numbers and write max and min of them;
read number of HTTP Error (400, 401,402, ...) and write the name of this error
(Declare enum HTTPError)
 */


public class Operators {
    public static void main(String[] arg) {

        int a = 5;
        int b = 0;
        int c = -5;

        int max = 5;
        int min = -5;

//int diapazon = b|a|c;
        if (a >= min && a <= max && b >= min && b <= max && c >= min && c <= max) {
            System.out.println("Дані числа лежать в діапазоні від -5 до 5");
        } else {
            System.out.println("Дані числа НЕ лежать в діапазоні від -5 до 5");
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