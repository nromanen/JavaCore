package lesson_3;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

/*Class Person should consist of
        three private fields: firstName, lastName and birthYear (the birthday year)
        properties for access to these fields
default constructor and constructor with 2 parameters (first and last names)
        methods:
        getAge() - to calculate the age of person
        input() - to input information about person
        output() - to output information about person
        changeName(String fn, String fn) - to change the first name or/and last name of person
        In the method main() create 5 objects of Person type and input information about them.
 String firstName = ();
     String secondName = ();
     int birthDay = ();

       String Person1 = input ();
     String Person2 = input ();
     String Person3 = input ();
     String Person4 = input ();
     String Person5 = input ();
*/
public class Person{
    //
    public static void main(String[] arg){

        System.out.println("Ваше імя?");
        Scanner imy = new Scanner(System.in);
        String firstName = imy.nextLine();
            System.out.println("Ваше прізвище?");
            Scanner dry = new Scanner(System.in);
            String secondName = dry.nextLine();
        System.out.println("Ваш рік народження?");
        Scanner dat = new Scanner(System.in);
        int birthDay = dat.nextInt();

public static void second(String[] arg){
            String Person1 = (firstName, lastName, birthYear);
            System.out.println(Person1);
        }
    }
}


