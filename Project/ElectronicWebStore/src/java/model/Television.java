/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import exceptions.BooleanException;
import exceptions.ResolutionException;
import exceptions.StringFieldException;
import exceptions.NumericValueException;
import java.util.Scanner;
/**
 *
 * @author dmytr
 */
public class Television extends ScreenCommodity {
  private boolean threeD; 
  private boolean smartTv;

    public Television() {
    }

    public Television(String brand, String model, double price, int screenSize, String res, boolean threeD, boolean smartTv)throws ResolutionException {
        super(brand, model, price, screenSize, res);
        this.threeD = threeD;
        this.smartTv = smartTv;
    }

    public boolean isThreeD() {
        return threeD;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setThreeD(boolean threeD) {
        this.threeD = threeD;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }
    public String toString(){
      return getBrand()+" "+getModel()+" Price:"+getPrice()+" Screen:"+getScreenSize()+" "+getRes()+
        "SmartTV:"+isSmartTv()+" 3D:"+isThreeD();
    }
    
    public String toHTML(){
      return "<p id=\"brandModel\">"+getBrand()+" "+getModel()+"</p>"
              +"<p id=\"screen\">ScreenSize:"+getScreenSize()
              +"</p>"+"<p id=\"res\">Resolution:"+getRes()+"</p>"+
              "<p id=\"smart_tv\">SmartTv:"+isSmartTv()+"</p>"+
              "<p id=\"3d\">3D:"+isThreeD()+"</p>"
              +"<p id=\"price\">Price:"+getPrice()+"</p>" 
              + "<input type=\"button\" id=\"comm"+getId()+"\" class=\"buy\" value=\"Buy\">";
    }
    
    public static Television input()throws StringFieldException,ResolutionException,NumericValueException,BooleanException{
      try{
        Television tv=new Television();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter brand:");
        tv.setBrand(sc.nextLine());
        System.out.println("Enter model:");
        tv.setModel(sc.nextLine());
        System.out.println("Enter price:");
        tv.setPrice(Double.valueOf(sc.nextLine()));
        System.out.println("Enter screen size:");
        tv.setScreenSize(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter resolution:");
        tv.setRes(sc.nextLine());
        System.out.println("Enter smartTv(true or false):");
        String smartTv=sc.nextLine();
        if(!smartTv.equals("true") && !smartTv.equals("false")){
            throw new BooleanException("smartTV");}
        else{tv.setSmartTv(Boolean.parseBoolean(smartTv));}
        System.out.println("Enter 3D(true or false):");
        String threeD=sc.nextLine();
        if(!threeD.equals("true") && !threeD.equals("false")){
            throw new BooleanException("3D");}
        else{tv.setThreeD(Boolean.valueOf(threeD));}
        return tv;
     }catch(NumberFormatException numEx){
        throw new NumericValueException();
     }
    }
}
