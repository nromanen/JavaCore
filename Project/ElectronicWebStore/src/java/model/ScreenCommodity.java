/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import exceptions.ResolutionException;
import exceptions.NumericValueException;
/**
 *
 * @author dmytr
 */
public abstract class ScreenCommodity extends Commodity{
  private double screenSize;
  private Resolution res;

    public ScreenCommodity() {
        super();
    }

    public ScreenCommodity(String brand,String model,double price,double screenSize,String res) throws ResolutionException {
        super(brand,model,price);
        this.screenSize = screenSize;
        this.res=strToRes(res);
    }
    public ScreenCommodity(String brand,String model,double price,int screenSize,String res) {
        super(brand,model,price);
        this.screenSize = screenSize;
        this.res = Resolution.valueOf(res);
    }
    public double getScreenSize() {
        return screenSize;
    }
    public String getRes() {
        return res.getResolution();
    }
    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
    public void setScreenSize(int screenSize) throws NumericValueException {
        this.screenSize = screenSize;
    }
    public void setRes(String res) {
        this.res = strToRes(res);
    }
    /**
     * 
     * @param res
     * @return
     * @throws ResolutionException 
     */
    public final Resolution strToRes(String res) throws ResolutionException{
      try{
        return Resolution.valueOf(res.toUpperCase());
      } catch(Exception ex){
        throw new ResolutionException();
      }
      /**switch(res.toUpperCase()){
          case "QHD":
          case "HD":
          case "FULL_HD":
          case "WQHD": 
          case "UHD":
          case "EIGHT_K":return Resolution.valueOf(res);            
          default:throw new ResolutionException();  
      }*/
    }
}
