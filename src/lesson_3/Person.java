package lesson_3;
import java.time.LocalDate;
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
    private String firstName;
    private String secondName;
    private int birthYear;

    public String getFirstName() {
        return firstName;
    }
    public void setSecondName(String name){
    secondName = name;
    }
    public void setBirthYear(int birthYear){
        if (birthYear>LocalDate.now().getYear()){
            throw new IllegalArgumentException("Рік народження не може бути більший " +
                    "ніж поточний");

        }
        this.birthYear = birthYear;
    }
    public void setFirstName(String name){this.firstName = name;
    }
    public Person(){
    }
    public Person(String s1, String s2, int s3){this.firstName = s1; this.secondName = s2;
    this.birthYear = s3;
    }
    public Person(String s2, int s3){this.firstName = "Bob"; this.secondName = s2;
        this.birthYear = s3;
    }
    public String toString(){
        return firstName + " " + secondName + " " + birthYear;
    }
        public int year(){
        return LocalDate.now().getYear() -birthYear;
        }
            public int howMuchAgeByYear(int year){
            return year - birthYear;
            }
    public static Person inputFromConsole(){
        Scanner sc = new Scanner(System.in);
        Person p1 = new Person();
        p1.setFirstName("IB");
        p1.setSecondName("jjhjk");
        int i = 0;
        do {
            System.out.println("Enter year of birth");
            i = Integer.parseInt(sc.nextLine());
        }
        while(i > 2020);
        p1.setBirthYear(i);
//        try{
//
//        }
//        catch(IllegalArgumentException e){
//
//            i = Integer.parseInt(sc.nextLine());
//        }
        return p1;
    }
}


