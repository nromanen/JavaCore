package Lesson3;
import java.util.Scanner;
public class week {

    public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Please input number of the day of the week: ");
            int day = in.nextInt();

            System.out.println(getDayName(day));
        }

        // Get the name for the Week
        public static String getDayName(int day) {
            String dayName = "";
            switch (day) {
                case 1: dayName = "Monday - Понеділок - Понедельник "; break;
                case 2: dayName = "Tuesday - Вівторок - Вторник "; break;
                case 3: dayName = "Wednesday - Середа - Среда "; break;
                case 4: dayName = "Thursday - Четверг - Четверг "; break;
                case 5: dayName = "Friday - Пятниця - Пятница "; break;
                case 6: dayName = "Saturday - Субота - Субота "; break;
                case 7: dayName = "Sunday - Неділя - Воскресенье "; break;
                default:dayName = "Invalid day range - Некоректно вказанний день тижня - Неверно указанный день недели ";
            }

            return dayName;
        }
    }