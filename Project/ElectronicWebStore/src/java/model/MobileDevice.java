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
public class MobileDevice extends Laptop {
  private int extMem;
  private int simCount;
  private int camera;
  private boolean gps;
  public MobileDevice(){
    super();
  }
  public MobileDevice(String brand, String model, double price, double screenSize,
    String res,int operMem, int intMem,int extMem,int simCount,int camera,boolean gps){
    super(brand,model,price,screenSize,res,operMem,intMem);
    this.extMem=extMem;
    this.simCount=simCount;
    this.camera=camera;
    this.gps=gps;
  }

    public int getExtMem() {
        return extMem;
    }

    public int getSimCount() {
        return simCount;
    }

    public int getCamera() {
        return camera;
    }

    public boolean isGps() {
        return gps;
    }

    public void setExtMem(int extMem) throws NumericValueException{
        if(extMem<0){throw new NumericValueException("Invalid value for external memory");}
        this.extMem = extMem;
    }

    public void setSimCount(int simCount) throws SimCountException {
        if(simCount>2 || simCount<1){throw new SimCountException();}
        this.simCount = simCount;
    }

    public void setCamera(int camera) throws NumericValueException{
        if(camera<=0){throw new NumericValueException("Invalid value for camera");}
        this.camera = camera;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
    public String toString(){
      return getBrand()+" "+getModel()+" Price: "+getPrice()+" ScreenSize:"+getScreenSize()+" Resolution:"+
        getRes()+" Operating memory:"+getOperMem()+
        " Internal memory"+getIntMem()+" External memory:"+extMem+" Sim cards"+simCount+
        " Camera"+camera+" GPS"+gps;
    }
    
    public String toHTML(){
      return "<p id=\"brandModel\">"+getBrand()+" "+getModel()+"</p>"
              +"<p id=\"screen\">ScreenSize:"+getScreenSize()+"</p>"+"<p id=\"res\">"+getRes()
              +"</p>"+"<p id=\"operatingMemory\">Operating memory:"+getOperMem()+"</p>"+
              "<p id=\"internalMemory\">Internal memory:"+getIntMem()+"</p>"+
              "<p id=\"externalMemory\">Internal memory:"+getExtMem()+"</p>"+
              "<p id=\"cameraOutput\">Internal memory:"+getCamera()+"</p>"+
              "<p id=\"sim\">Internal memory:"+getSimCount()+"</p>"+
              "<p id=\"gpsOutput\">Internal memory:"+isGps()+"</p>"
              +"<p id=\"price\">Price:"+getPrice()+"</p>" 
              + "<input type=\"button\" id=\"comm"+getId()+"\" class=\"buy\" value=\"Buy\">";
    }
    
    public static MobileDevice input()throws SimCountException,StringFieldException,ResolutionException,NumericValueException,BooleanException{
      try{
        MobileDevice mobile=new MobileDevice();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter brand:");
        mobile.setBrand(sc.nextLine());
        System.out.println("Enter model:");
        mobile.setModel(sc.nextLine());
        System.out.println("Enter price:");
        mobile.setPrice(Double.valueOf(sc.nextLine()));
        System.out.println("Enter screen size:");
        mobile.setScreenSize(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter resolution:");
        mobile.setRes(sc.nextLine());
        System.out.println("Enter operating memory:");
        mobile.setOperMem(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter internal memory:");
        mobile.setIntMem(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter external memory:");
        mobile.setExtMem(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter number of simCards:");
        mobile.setSimCount(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter camera's mPx:");
        mobile.setCamera(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter GPS(true or false):");
        String gps=sc.nextLine();
        if(!gps.equals("true") && !gps.equals("false")){
            throw new BooleanException("3D");}
        else{mobile.setGps(Boolean.parseBoolean(gps));}
        return mobile;
     }catch(NumberFormatException numEx){
        throw new NumericValueException();
     }
    }
   
}
