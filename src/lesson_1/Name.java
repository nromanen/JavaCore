package lesson_1;
import java.io.InputStream;
import java.util.Scanner;

public class Name {
    public static void main(String[] arg){

        System.out.print("Як Вас звати? ");
        Scanner name1 = new Scanner(System.in);
        String namee = name1.nextLine();
        System.out.println ("Де Ви проживаєте, " + namee + "?");

        Scanner adres = new Scanner(System.in);
        String adress = adres.nextLine();
        System.out.println ("Класне місце " +adress + ", " + namee + "!");

    }

}
