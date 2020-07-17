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
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author dmytr
 */
public class Accesorie extends Commodity{
    private String name;
    private String shortDescription;
    public Accesorie(){
      super();
    }
    public Accesorie(String name, String brand, String model, double price,String shortDescription) {
        super(brand, model, price);
        this.name = name;
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setName(String name) throws StringFieldException {
        if(name.isEmpty() || name.length()>20){throw new StringFieldException("name",1,30);}
        Pattern p=Pattern.compile("[A-Z]+[a-zA-Z]+((\\s{1})([A-Za-z]+))*");
        Matcher matcher=p.matcher(name);
        if(!matcher.matches()){throw new StringFieldException("Wrong name.Try again");}
        this.name = name;
    }

    public void setShortDescription(String shortDescription) throws StringFieldException {
        if(shortDescription.isEmpty() || shortDescription.length()>50){
            throw new StringFieldException("short description",1,50);}
        Pattern p=Pattern.compile("[A-Z]+((\\s*)(\\w+))+");
        Matcher matcher=p.matcher(name);
        if(!matcher.matches()){throw new StringFieldException("Wrong short description.Try again");}
        this.shortDescription = shortDescription;
    }
    public String toString(){
      return name+" "+getBrand()+" "+getModel()+" Price"+getPrice()+" Short Description: "+shortDescription;
    }
    public String toHTML(){
      return "<p id=\"accType\">"+name+"</p>"
              +"<p id=\"brandModel\">"+getBrand()+" "+getModel()+"</p>"
              +"<p id=\"shortDesc\">Short description::"+shortDescription+"</p>"              
              +"<p id=\"price\">Price:"+getPrice()+"</p>" 
              + "<input type=\"button\" id=\"buy\" value=\"Buy\">";
    }
    public static Accesorie input()throws StringFieldException,ResolutionException,NumericValueException,BooleanException{
      try{
        Accesorie acc=new Accesorie();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter type of accesorie:");
        acc.setName(sc.nextLine());
        System.out.println("Enter brand:");
        acc.setBrand(sc.nextLine());
        System.out.println("Enter model:");
        acc.setModel(sc.nextLine());
        System.out.println("Enter price:");
        acc.setPrice(Double.valueOf(sc.nextLine()));
        System.out.println("Enter short description:");
        acc.setShortDescription(sc.nextLine());        
        return acc;
     }catch(NumberFormatException numEx){
        throw new NumericValueException();
     }
    }
}
