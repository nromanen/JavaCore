package lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class month3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input Month number in the Year from 1 to 12 : ");
        int month;
        month = in.nextInt();
        System.out.println(getMonthDays2(month));
    }

    private static String getMonthDays2(int month) {

        String dayQuantity = "";

        String[] monthYear = new String[12];
        monthYear[0]="January = 31 days" ;
        monthYear[1]="February = 29 days";
        monthYear[2]="March = 31 days";
        monthYear[3]="April = 30 days";
        monthYear[4]="May = 31 days";
        monthYear[5]="June = 30 days";
        monthYear[6]="July = 31 days";
        monthYear[7]="August = 31 days";
        monthYear[8]="September = 30 days";
        monthYear[9]="October = 31 days";
        monthYear[10]="November = 30 days";
        monthYear[11]="December = 31 days";

        switch (month) {
            case 1: return monthYear[month-1];
            case 2: return monthYear[month-1];
            case 3: return monthYear[month-1];
            case 4: return monthYear[month-1];
            case 5: return monthYear[month-1];
            case 6: return monthYear[month-1];
            case 7: return monthYear[month-1];
            case 8: return monthYear[month-1];
            case 9: return monthYear[month-1];
            case 10: return monthYear[month-1];
            case 11: return monthYear[month-1];
            case 12: return monthYear[month-1];

            default:
                dayQuantity = "You entered wrong month number. Please try one more time. ";
        }

        return dayQuantity;

    }
}

