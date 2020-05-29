package src;


public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Litl", Dog.Breed.AKITA, 2);
        Dog dog2 = new Dog("Bell", Dog.Breed.BULLDOG, 8);
        Dog dog3 = new Dog("Bells", Dog.Breed.TERRIER, 1);
        Dog.oldest(dog1, dog2, dog3);

        System.out.println(Dog.chekName(dog1,dog2,dog3));
        System.out.println();

        System.out.println(ReadNumbers.chekfloat(1.56f, 5.5f, 3.5f));
        ReadNumbers.max_min_int(10, 5, 85, 99, 101, 5);
        ReadNumbers.httpError(401);

        Practical.dayOfWeek(5);
        Practical.nameContinent("fRancE");

        Product product1 = new Product("Apple", 3.45,5.0);
        Product product2 = new Product("Graps", 6.50,7.0);
        Product product3 = new Product("Mellon", 10000.15,9.0);
        Product product4 = new Product("Lemon", 51.15,0.0);
        Product.mostExpensive(product1, product2, product3, product4);
        Product.biggestQuantity(product1, product2, product3, product4);




    }
}
