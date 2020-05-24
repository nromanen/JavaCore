import Models.Employee;
import Models.Person;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        person1.input("Vasilii", "Tod", "2015-06-10");
        person2.input("Mike", "Anderson", "1986-07-18");
        person3.input("Stiv", "Duglas", "2000-11-10");
        person4.input("Nick", "Tjmason", "2001-07-10");
        person5.input("Alice", "Metissom", "1999-06-15");
        // System.out.println(person1.output());
        // person1.changeName("Andry","Felipos");


        System.out.println();

        Employee employee = new Employee("Stas", 256.20, 30.20);
        Employee employee1 = new Employee("Vasil", 32.20, 65);
        Employee employee2 = new Employee("Leonid", 23.50, 30.4);
        //employee.changeRate(10000);
        //System.out.println(employee);
        //employee.getBonuse();
        System.out.println(Employee.getTotalSum());


    }
}
