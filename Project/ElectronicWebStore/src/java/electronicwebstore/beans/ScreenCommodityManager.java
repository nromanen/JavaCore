/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicwebstore.beans;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author dmytr
 */
public abstract class ScreenCommodityManager extends CommodityManager{
  private String screenSize;
  private String resolution;
  
  public void filterByResolution(){
    if(resolution!=null && !resolution.equals("All resolutions")){
      comms=comms.stream().filter(c->(((ScreenCommodity)c).getRes().toUpperCase()
              .equals(resolution.toUpperCase()))).collect(Collectors.toList()); 
    }
  }
  public void filterByScreenSize(){
    if(screenSize!=null && !screenSize.equals("All screensizes")){
      comms=comms.stream().filter(c->(((ScreenCommodity)c).getScreenSize()==Double.valueOf(screenSize)))
              .collect(Collectors.toList());
    }
  }
  
  public String getScreenSize() {
        return screenSize;
  }   
    
  public String getResolution() {
        return resolution;
  }
  public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
  }    

  public void setResolution(String resolution) {
        this.resolution = resolution;
  }

}
