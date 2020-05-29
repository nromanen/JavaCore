//Сreate class Dog with fields name, breed, age.
//        Declare enum for field breed.
//        Create 3 instances of type Dog.
//        Check if there is no two dogs with the same name.
//        Display the name and the kind of the oldest dog.

package src;

import java.util.*;

public class Dog // implements Comparable
{


    enum Breed {AKITA, BULLDOG, TERRIER}

    private String name;
    private Breed breed;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, Breed breed, int age) {
        setName(name);
        setBreed(breed);
        setAge(age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", breed=" + getBreed() +
                ", birthYear=" + getAge() +
                '}';
    }

    public static void oldestDog(Dog dog1, Dog dog2, Dog dog3) {
        int d1 = dog1.getAge();
        int d2 = dog1.getAge();
        int d3 = dog1.getAge();
        if (d1 > d2 && d1 > d3) {
            System.out.println(dog1.getName() + " the oldest dog");
        } else if (d2 > d1 && d2 > d3) {
            System.out.println(dog2.getName() + " the oldest dog");
        } else if (d3 > d1 && d3 > d2) {
            System.out.println(dog3.getName() + " the oldest dog");
        } else System.out.println("All dogs have same age");

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Dog other = (Dog) obj;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!(this.name.equals(other.name))) return false;

        return true;


    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static boolean chekName(Dog dog1, Dog dog2, Dog dog3) {
        return (dog1.equals(dog2) || dog1.equals(dog3) || dog2.equals(dog3));

    }

//    public static void oldest (Dog...dogs){
//        Set<Dog> dog = new TreeSet<>();
//        for (Dog d: dogs
//             ) {
//            dog.add(d);
//        }
//        System.out.println(dog);
//    }

//    @Override
//    public int compareTo(Object o) {
//        if(this.age>o.age)
//        return 1;
//        if (this.age<o.age)
//            return -1;
//        else return 0;
//    }
}
