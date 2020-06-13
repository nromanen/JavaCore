package lesson_3;

import java.util.Scanner;

public class Main {



    public static void main(String[] arg) {

        Person p = Person.inputFromConsole();
        Person p2 = Person.inputFromConsole();
        System.out.println(p + "±±±" +p2);

           Person p1 = new Person();
           p1.setFirstName("Ivan");
           p1.setSecondName("Priz");
           p1.setBirthYear(2017);



       Person s1 = new Person("Giv", 1980);
        //System.out.println(s1 + " " + p1);
        p1.setSecondName("Olya");
        System.out.println(s1 + " " + p1);

        System.out.println("ім'я змінної p1?");
        System.out.println(p1.getFirstName());
        System.out.println(p1 + " - " +  p1.year() + " років");
        System.out.println(p1 + " - " +  p1.howMuchAgeByYear(1990) + " років");

      /*  Scanner imy = new Scanner(System.in);
        String firstName = imy.nextLine();
        System.out.println("Ваше прізвище?");
        Scanner dry = new Scanner(System.in);
        String secondName = dry.nextLine();
        System.out.println("Ваш рік народження?");
        Scanner dat = new Scanner(System.in);
        int birthDay = dat.nextInt();

 */
    }

}
