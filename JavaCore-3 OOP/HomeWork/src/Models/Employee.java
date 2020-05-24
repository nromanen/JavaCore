//PracticTask
//        Create Console Application project in Java.
//        Add class Employee to the project.
//        Class Employee should consist of
//        three private fields: name, rate and hours;
//        static field totalSum
//        properties for access to these fields;
//        default constructor, constructor with 2 parameters (name and rate) and constructor with 3 parameters;
//        methods:
//        getSalary() - to calculate the salary of person (rate * hours)
//        toString() - to output information about employee
//        changeRate(int rate) - to change the rate of some employee and recalculate his salary
//        getBonuses() – to calculate 10% from salary
//        In the method main() create 3 objects of Employee type. Input information about them.
//        Display the total salary of all workers to screen


package Models;

public class Employee {

    private String name;
    private double rate;
    private double hours;
    static double totalSum;

    public Employee() {
    }


    public Employee(String name, double rate) {
        setName(name);
        setRate(rate);
        this.hours = 0;
        setTotalSum(getTotalSum() + getSalary());

    }

    public Employee(String name, double rate, double hours) {
        setName(name);
        setRate(rate);
        setHours(hours);
        setTotalSum(getTotalSum() + getSalary());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public static double getTotalSum() {
        return totalSum;
    }

    private  void setTotalSum(double totalSum) {
        Employee.totalSum = totalSum;
    }

    private double getSalary() {
        return rate * hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", hours=" + hours +
                ", salary=" + getSalary() + '}';
    }

    public void changeRate(int rate) {
        setTotalSum(getTotalSum() - getSalary());
        setRate(rate);
        setTotalSum(getTotalSum() + getSalary());
    }

    public double getBonuse() {
        double bonus = (getSalary() * 10) / 100;
        setTotalSum(getTotalSum() + bonus);
        return bonus;

    }

}
