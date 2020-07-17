/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicwebstore.beans;

import exceptions.SimCountException;
import exceptions.StringFieldException;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import model.*;
/**
 *
 * @author dmytr
 */
public abstract class CommodityManager implements Serializable {
  private String brand;
  private int minPrice;
  private int maxPrice;
  List<Commodity> comms=new ArrayList();
   public void filterByPriceRange() throws SQLException,StringFieldException,SimCountException {
      if(maxPrice-minPrice>0){
        comms=comms.stream().filter(c->(c.getPrice()>minPrice && c.getPrice()<maxPrice))
                .collect(Collectors.toList());
      }
    }
  public void filterByBrand(){
    if(brand!=null && !brand.equals("All brands")){
      comms=comms.stream().filter(c->(c.getBrand().toUpperCase().equals(brand.toUpperCase())))
              .collect(Collectors.toList()); 
    }
  }
  public List<Commodity> getComms() {
        return comms;
    }
  
  public String getBrand() {
        return brand;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
    public void setComms(List<Commodity> comms) {
        this.comms = comms;
    }
}
