package lesson4;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

class Car3{
    String name;
    int year;
    int engine;

    public Car3(String name, int year, int engine){
        this.name = name;
        this.year = year;
        this.engine = engine;
    }


    public String toString(){
        return "(" + name + ", " + year + " year)" + engine + "engine capacity";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }
}

class Library {

    static private Comparator<Car3> ascName;
    static private Comparator<Car3> descYear;

    static {
        ascName = new Comparator<Car3>() {
            @Override
            public int compare(Car3 b1, Car3 b2) {
                return b1.getName().compareTo(b2.getName());
            }
        };

        descYear = new Comparator<Car3>() {
            @Override
            public int compare(Car3 b1, Car3 b2) {

                return Integer.compare(b1.getYear(), b2.getYear());
            }
        };
    }

    private Car3[] car3s;

    public Car3[] getCar3s() {
        return car3s;
    }

    public void sortAscName() {
        Arrays.sort(car3s, ascName);
    }

    public void sortdescYear() {
        Arrays.sort(car3s, descYear);
    }

    public Library(Car3[] car3s) {
        this.car3s = car3s;
    }

    public static void main(String[] args) {
        Library library = new Library(new Car3[]{
                new Car3("BMW", 2012, 200),
                new Car3("AUDI", 2013, 175),
                new Car3("Volvo", 2015, 120),
                new Car3("VW", 2012, 150),
        });


        /*library.sortAscName();
        System.out.println(Arrays.toString(library.getCar3s()));*/

        library.sortdescYear();
        System.out.println("Hello Dear user ! We are sorting cars by year of production :");
        System.out.println(Arrays.toString(library.getCar3s()));

        Car3[] cars = {new Car3("BMW", 2012, 200),
                new Car3("AUDI", 2013, 175),
                new Car3("Volvo", 2015, 120),
                new Car3("VW", 2012, 150)
        };

        Scanner in = new Scanner(System.in);
        System.out.println("Please input Year of Production of the car you are interested in = ");
        int year;
        year = in.nextInt();


        System.out.println("Cars of input year:");
        Car3[] car3s = showCars(cars,year);
        for(int i=0;i<cars.length;i++){
            if (year==cars[i].getYear())
            System.out.println(" Car name = "+cars[i].getName()+" "+" Engine_Capacity "+cars[i].getEngine()+"hp ");

    }
        System.out.print("Thank You !!! Good day !!!");
           }

    private static Car3[] showCars(Car3[] cars, int year) {
        return cars;
    }


}





