package lesson_1;
/*
Phone calls from three different countries are с1, с2 and с3 standard units per minute.
Talks continued t1, t2 and t3 minutes.
How much computer will count for each call separately and all talk together?
Input all source data from console, make calculations and output to the screen.
*/
public class Phone{
    public static void main(){

    int c1 = 1;
    int c2 = 2;
    int c3 = 3;

    double t1 = 1.5;
    double t2 = 2.5;
    int t3 = 3;

        double cina1 = c1 * t1;
        double cina2 = c2 * t2;
        int cina3 = c3 * t3;

System.out.println(cina1 + cina2 + cina3);
    }
}
