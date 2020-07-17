/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import exceptions.StringFieldException;
import exceptions.NumericValueException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.Serializable;
/**
 *
 * @author dmytr
 */
public abstract class Commodity implements Serializable {
    private int id;
    private String brand;
    private String model;
    private double price;

    public Commodity() {
    }

    public Commodity(String brand,  String model, double price) {
        this.brand = brand;
        this.model=model;
        this.price = price;
    }

    public String getBrand() {        
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    
    //TODO add regex
    public void setBrand(String brand) throws StringFieldException{
        if(brand.isEmpty() || brand.length()>20){throw new StringFieldException("brand",1,20);}
        Pattern p=Pattern.compile("^[A-Z]+((\\s?)[a-zA-Z])+");
        Matcher matcher=p.matcher(brand);
        if(!matcher.matches()){throw new StringFieldException("Wrong brand.Try again");}
        this.brand = brand;
    }

    public void setModel(String model) throws StringFieldException {
        if(model.isEmpty() || model.length()>20){throw new StringFieldException("model",1,20);}
        Pattern p=Pattern.compile("^[A-Z]+((\\s?)(\\w+))+");
        Matcher matcher=p.matcher(model);
        if(!matcher.matches()){throw new StringFieldException("Wrong model.Try again");}
        this.model = model;
    }

    public void setPrice(double price) throws NumericValueException {
        if(price<=0)throw new NumericValueException("Price should be higher than 0");
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
     
}
