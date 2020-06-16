package Lesson3;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

enum Gender{MALE, FEMAlE}

public class Person {

    private String firstName;
        private String LastName;
        private int birthYear;
    private static final int SCHOOL_AGE = 7;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) throws IOException{
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(" Enter FirstName please ");

        String userFirstName = myObj.nextLine();  // Read user input
        System.out.println("Username FirstName is : " + userFirstName);  // Output user input
        this.firstName = userFirstName;
    }
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) throws IOException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username LastName please");

        String userLastName = myObj.nextLine();  // Read user input
        System.out.println("Username LastName is: " + userLastName);  // Output user input
        LastName = userLastName;
    }
    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Birth Year cannot be more now year");
        }
        this.birthYear = birthYear;
    }
        public static Person inputFromConsole() throws IOException {
            Scanner sc = new Scanner(System.in);
            Person p1 = new Person();
            p1.setFirstName("");
            p1.setLastName("");

            int i =0;
            do{
                System.out.println("Enter Birth Year please ");
                i = Integer.parseInt(sc.nextLine());

            }
            while (i>2020);
            p1.setBirthYear(i);

            try {

            }
            catch (IllegalArgumentException e){
                System.out.println("Enter birthYear one more time");
                i = Integer.parseInt(sc.nextLine());
            }
            return p1;
        }

    public Person (){

}
    public Person(String firstName, String LastName, int birthYear) {

        this.firstName = firstName; this.LastName =LastName;this.birthYear = birthYear;

    }
    @Override
    public String toString() {
        return 
                " firstName : '" + firstName + '\'' +
                ", LastName : '" + LastName + '\'' +
                ", birthYear : " + birthYear ;
    }

    public int getAge(){
    return LocalDate.now().getYear() - birthYear;
    }

    public int howMuchAgeByYear(){
        return birthYear + SCHOOL_AGE;
    }

    public Gender getGenderByLastName(String firstName) {

        String glasLetters = "аеєіїоуяю";
        String [] soglasLetters = new String[] {"q", "w", "r", "t", "p", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};

        char lastLetterName = firstName.charAt(firstName.length() - 1);
        glasLetters.indexOf(lastLetterName);
        if (glasLetters.indexOf(lastLetterName) == -1) {
            return Gender.MALE;
        }
        return Gender.FEMAlE;
    }

    public void setLastName() {
    }

    public void setFirstName() {
    }

}



