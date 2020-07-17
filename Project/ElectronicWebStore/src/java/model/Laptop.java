/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.BooleanException;
import exceptions.NumericValueException;
import exceptions.ResolutionException;
import exceptions.StringFieldException;
import exceptions.SimCountException;
import java.util.Scanner;

/**
 *
 * @author dmytr
 */
public class Laptop extends ScreenCommodity {
  private int operMem;
  private int intMem;
    public Laptop(){
      super();
    }
    public Laptop(String brand, String model, double price, int screenSize, String res,int operMem, int intMem) {
        super(brand, model, price, screenSize, res);
        this.operMem = operMem;
        this.intMem = intMem;
    }

    public Laptop(String brand, String model, double price, double screenSize, String res,int operMem, int intMem) throws ResolutionException {
        super(brand, model, price, screenSize, res);
        this.operMem = operMem;
        this.intMem = intMem;
    }

    public int getOperMem() {
        return operMem;
    }

    public int getIntMem() {
        return intMem;
    }

    public void setOperMem(int operMem) throws NumericValueException {
        if(operMem<=0){throw new NumericValueException("Invalid value for operating memory");}
        this.operMem = operMem;
    }

    public void setIntMem(int intMem) throws NumericValueException{
        if(intMem<=0){throw new NumericValueException("Invalid value for internal memory");}
        this.intMem = intMem;
    }
    public String toString(){
      return getBrand()+" "+getModel()+" Price:"+getPrice()+" ScreenSize:"+getScreenSize()+" Resolution:"+
        getRes()+" Operating memory:"+operMem+" Internal memory"+intMem;
    }
    public String toHTML(){
      return "<p id=\"brandModel\">"+getBrand()+" "+getModel()+"</p>"
              +"<p id=\"screen\">ScreenSize:"+getScreenSize()+"</p>"+"<p id=\"res\">"+getRes()
              +"</p>"+"<p id=\"operatingMemory\">Operating memory:"+getOperMem()+"</p>"+
              "<p id=\"internalMemory\">Internal memory:"+getIntMem()+"</p>"
              +"<p id=\"price\">Price:"+getPrice()+"</p>" 
              + "<input type=\"button\" id=\"buy\" value=\"Buy\">";
    }
    public static Laptop input()throws SimCountException,StringFieldException,ResolutionException,NumericValueException,BooleanException{
      try{
        Laptop laptop=new Laptop();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter brand:");
        laptop.setBrand(sc.nextLine());
        System.out.println("Enter model:");
        laptop.setModel(sc.nextLine());
        System.out.println("Enter price:");
        laptop.setPrice(Double.valueOf(sc.nextLine()));
        System.out.println("Enter screen size:");
        laptop.setScreenSize(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter resolution:");
        laptop.setRes(sc.nextLine());
        System.out.println("Enter operating memory:");
        laptop.setOperMem(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter internal memory:");
        laptop.setIntMem(Integer.parseInt(sc.nextLine()));
        return laptop;
     }catch(NumberFormatException numEx){
        throw new NumericValueException();
     }
    }
        
}
