/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicwebstore.beans;

import exceptions.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.*;
import dataloader.DataLoader;

/**
 *
 * @author dmytr
 */
public class TvManager extends ScreenCommodityManager {
  private String[] smartTv={"off","off"};
  private String[] threeD={"off","off"};
  private String[] screenSizeRange={"All","All"};
  
  public String filter() throws SQLException,StringFieldException,SimCountException{    
   
    comms.add(new Television("Samsung","UWE7600",20000.00,45,"FULL_HD",true,true));
    comms.add(new Television("Samsung","UWE8100",30000.00,55,"WQHD",true,true));
    comms.add(new Television("SONY","KW4520",25000.00,45,"FULL_HD",true,true));
    comms.add(new Television("SONY","KW4520",25000.00,45,"FULL_HD",false,false));
    comms.add(new Television("Samsung","LWE5500",25000.00,45,"FULL_HD",true,false));
    //DataLoader data=new DataLoader();
    //comms.addAll(data.filterBy(Television.class));
    //data.close();
    filterByPriceRange();
    filterByScreenSizeRange();
    filterByBrand();
    filterByResolution();
    filterBySmartTv(smartTv);
    filterByThreeD(threeD);
    String output=print(comms);
    dropValues();
    return output;
   
  }
  
 public String print(List<Commodity> comm){
    String result="";    
    for(int i=0;i<comms.size();i++){
      if((i==0) || (i%3==0)){result+="<div id=\"commodityRow\">";}
      result+="<div class=\"comm"+comms.get(i).getId()+"\" id=\"commodity\">"+addImage((Television)comms.get(i))+
              ((Television)comms.get(i)).toHTML()+"</div>";
      if(((i+1)%3==0 && i>0) || (i==(comms.size()-1))){result+="</div>";}
    }
    return result;
  }
  
  public void filterBySmartTv(String[] checks){
    if(!checks[0].equals(checks[1])){     
          if(checks[1].equals("off")){
            comms=comms.stream().filter(c->(((Television)c).isSmartTv()==Boolean.valueOf(checks[0])))
              .collect(Collectors.toList());
          }            
    }
  }
  public void filterByScreenSizeRange(){
    if(!screenSizeRange[0].equals("All") && !screenSizeRange[1].equals("All")){
      comms=comms.stream().filter(c->((ScreenCommodity)c).getScreenSize()>=Integer
              .parseInt(screenSizeRange[0]) && ((ScreenCommodity)c).getScreenSize()<Integer
              .parseInt(screenSizeRange[1])).collect(Collectors.toList());
    }
  }
  public void filterByThreeD(String[] checks){
    if(!checks[0].equals(checks[1])){     
          if(checks[1].equals("off")){
            comms=comms.stream().filter(c->(((Television)c).isThreeD()==Boolean.valueOf(checks[0])))
              .collect(Collectors.toList());
          }            
    }
  }
  
  private void dropValues(){
    comms=new ArrayList();
    for(int i=0;i<smartTv.length;i++){
      smartTv[i]="off";
      threeD[i]="off";
      screenSizeRange[i]="All";
    }
  }
  
   private String addImage(Television tv){
    return "<img src=\"images\\tv-"+tv.getBrand().toLowerCase()+
              ".jpg\" alt=\""+tv.getBrand()+" "+tv.getModel()+"\">";
  }

    public String[] getScreenSizeRange() {
        return screenSizeRange;
    }
  
    public String[] getSmartTv() {
    return smartTv;
    }
    public String[] getThreeD() {
    return threeD;
    }
    
    public void setScreenSizeRange(String screenSizeRange){
      if(!screenSizeRange.equals("All screensizes") && !screenSizeRange.equals(">70")){
        this.screenSizeRange=screenSizeRange.split("-");
      }
      if(screenSizeRange.equals(">70")){
        this.screenSizeRange[0]="70";
        this.screenSizeRange[1]="200";
      }
    }
   
    public void setSmartTv(String[] smartTv) {
      for(int i=0;i<smartTv.length;i++){
        if(smartTv[i]!=null && !smartTv[i].isEmpty()){this.smartTv[i]=smartTv[i];}
      }
    }
    public void setThreeD(String[] threeD) {
      for(int i=0;i<threeD.length;i++){
        if(threeD[i]!=null && !threeD[i].isEmpty()){this.threeD[i]=threeD[i];}
      }
    }    
}

