//HomeWork
// Create Console Application project in Java.
//        Add class Person to the project.
//        Class Person should consist of
//        three private fields: firstName, lastName and birthYear (the birthday year)
//        properties for access to these fields
//        default constructor and constructor with 2 parameters (first and last names)
//        methods:
//        getAge() - to calculate the age of person
//        input() - to input information about person
//        output() - to output information about person
//        changeName(String fn, String fn) - to change the first name or/and last name of person
//        In the method main() create 5 objects of Person type and input information about them.


package Models;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthYear; // Замість int  для більш точно вираховування віку застосовується дата народження формату yyyy-MM-dd

    public Person() {
    }

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);

    }

    protected String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    protected String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }


    private void setBirthYear(String birthYear) {

        this.birthYear = LocalDate.parse(birthYear);
    }

    LocalDate getBirthYear() {
        return birthYear;
    }

    public int getAge() {

        LocalDate localDate = LocalDate.now();

        return Period.between(birthYear, localDate).getYears();
    }

    public void input(String fn, String ln, String dt) {
        setFirstName(fn);
        setLastName(ln);
        setBirthYear(dt);
    }


    public String output() {
        return "Person{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birthYear=" + getBirthYear() +
                ", age=" + getAge() +
                '}';

    }


    //Недолік такого рішення в тому, що при одному лише параметру метода він визначається як firstName
//хоча цілком може бути lastName.
    public void changeName(String... fn) {
        if (2 < fn.length) {
            try {
                throw new Exception("Invalid data, you input more than 2 names");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        if (2 > fn.length) {
            setFirstName(fn[0]);
        } else {
            setFirstName(fn[0]);
            setLastName(fn[1]);
        }


    }
    // Данний метод вимагає наявність усіх параметрів, навіть якщо немає необхідності в зміні одразу двух names
    //    public void changeName(String fn, String ln) {
//        if (!(fn.isEmpty()) && !(fn.equals(getFirstName()))) {
//            setFirstName(fn);
//            if (!(ln.isEmpty()) && !(ln.equals(getLastName()))) {
//                setLastName(ln);
//            }
//
//        }
//        if (!(ln.isEmpty()) && !(ln.equals(getLastName()))) {
//            setLastName(ln);
//        }
//
//    }
}

