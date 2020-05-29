package src;
//Create class Product with fields name, price and quantity.
//        Create four instances of type Product.
//        Display the name and quantity of the most expensive item.
//        Display the name of the items, which has the biggest quantity.


import java.util.*;

public class Product {

    private String name;
    private double price;
    private double quantity;
    private double cost;

    public Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        setCost();
    }

    public double getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = getPrice()*getQuantity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static void mostExpensive(Product dp1, Product dp2, Product dp3, Product dp4
    ) {
        double d1 = dp1.getCost();
        double d2 = dp2.getCost();
        double d3 = dp3.getCost();
        double d4 = dp4.getCost();
        ;
        if (d1 > d2 && d1 > d3 && d1 > d4) {
            System.out.println(dp1.getName() + " the most expensive product " + "quantity: " + dp1.getQuantity());
        } else if (d2 > d1 && d2 > d3 && d1 > d4) {
            System.out.println(dp2.getName() + " the most expensive product" + "quantity: " + dp2.getQuantity());
        } else if (d3 > d1 && d3 > d2 && d1 > d4) {
            System.out.println(dp3.getName() + " the most expensive product" + "quantity: " + dp3.getQuantity());
        } else if (d4 > d1 && d4 > d2 && d4 > d3) {
            System.out.println(dp4.getName() + " the most expensive product" + "quantity: " + dp4.getQuantity());
        } else System.out.println("All products have same price");

    }

    public static void biggestQuantity(Product dp1, Product dp2, Product dp3, Product dp4) {
        double d1 = dp1.getQuantity();
        double d2 = dp2.getQuantity();
        double d3 = dp3.getQuantity();
        double d4 = dp4.getQuantity();
        if (d1 > d2 && d1 > d3 && d1 > d4) {
            System.out.println(dp1.getName() + " highest quantity " + dp1.getQuantity());
        } else if (d2 > d1 && d2 > d3 && d1 > d4) {
            System.out.println(dp2.getName() + " highest quantity " + dp1.getQuantity());
        } else if (d3 > d1 && d3 > d2 && d1 > d4) {
            System.out.println(dp3.getName() + " highest quantity " + dp1.getQuantity());
        } else if (d4 > d1 && d4 > d2 && d4 > d3) {
            System.out.println(dp4.getName() + " highest quantity " + dp1.getQuantity());
        } else System.out.println("All products have same quantity");

    }


}


