/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicwebstore.beans;

import exceptions.SimCountException;
import exceptions.StringFieldException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Commodity;
import model.Laptop;
import model.MobileDevice;

/**
 *
 * @author dmytr
 */
public class MobileManager extends LaptopManager{
  String extMem;
  String camera;
  String simCount;
  String[] gps={"off","off"};
  
  public String filter() throws SQLException,StringFieldException,SimCountException{
    comms.add(new MobileDevice("Apple","Iphone 7",20000.00,5,"FULL_HD",2,64,0,1,16,true));
    comms.add(new MobileDevice("Samsung","S20",35000.00,5,"WQHD",6,256,256,2,20,true));
    comms.add(new MobileDevice("Samsung","A31",15000.00,6,"FULL_HD",4,32,128,2,16,true));
    comms.add(new MobileDevice("Samsung","M31",9000.00,5,"FULL_HD",2,16,128,2,16,false));
    comms.add(new MobileDevice("Huawei","Honor",15000.00,5,"WQHD",4,256,256,2,20,true));
    //DataLoader data=new DataLoader();
    //comms.addAll(data.filterBy(MobileDevice.class));
    //data.close();
    filterByPriceRange();
    filterByScreenSize();
    filterByBrand();
    filterByResolution();
    filterByOperMem();
    filterByIntMem();
    filterByExtMem();
    filterByCamera();
    filterBySimCount();
    filterByGps();
    String output=print(comms);
    dropValues();
    return output;
  }
  
 public String print(List<Commodity> comm){
    String result="";    
    for(int i=0;i<comms.size();i++){
      if((i==0) || (i%3==0)){result+="<div id=\"commodityRow\">";}
      result+="<div class=\"comm"+comms.get(i).getId()+"\" id=\"commodity\">"+addImage((MobileDevice)comms.get(i))+
              ((MobileDevice)comms.get(i)).toHTML()+"</div>";
      if(((i+1)%3==0 && i>0) || (i==(comms.size()-1))){result+="</div>";}
    }
    return result;
  }
  
  private void dropValues(){
    comms=new ArrayList();
    for(int i=0;i<gps.length;i++){
      gps[i]="off";      
    }
  }
  
  public void filterByExtMem(){
    if(extMem!=null && !extMem.equals("All")){
      comms=comms.stream().filter(c->((MobileDevice)c).getExtMem()==Integer.parseInt(extMem))
              .collect(Collectors.toList());
    }
  }
  
  public void filterByCamera(){
    if(camera!=null && !camera.equals("All")){
      comms=comms.stream().filter(c->((MobileDevice)c).getCamera()==Integer.parseInt(camera))
              .collect(Collectors.toList());
    }
  }
  
  public void filterBySimCount(){
    if(simCount!=null && !simCount.equals("Any")){
      comms=comms.stream().filter(c->((MobileDevice)c).getSimCount()==Integer.parseInt(simCount))
              .collect(Collectors.toList());
    }
  }
  
  public void filterByGps(){
    if(!gps[0].equals(gps[1])){     
          if(gps[1].equals("off")){
            comms=comms.stream().filter(c->(((MobileDevice)c).isGps()==Boolean.valueOf(gps[0])))
              .collect(Collectors.toList());
          }            
    }
  }
  
  private String addImage(MobileDevice mobile){
    if(mobile.getBrand().equals("Samsung") || mobile.getBrand().equals("Apple"))
      return "<img src=\"images\\mobileDevice-"+mobile.getBrand().toLowerCase()+"-"
            +mobile.getModel().toLowerCase()+".jpg\" alt=\""+mobile.getBrand()
              +" "+mobile.getModel()+"\">";
    if(mobile.getBrand().equals("Huawei") || mobile.getBrand().equals("Meize") 
            || mobile.getBrand().equals("Xiaomi")){
      return "<img src=\"images\\mobileDevice-"+mobile.getBrand().toLowerCase()+
              ".jpg\" alt=\""+mobile.getBrand()+" "+mobile.getModel()+"\">";
    }
    return "<img src=\"images\\mobileDevice-smartphone.jpg\" alt=\""+mobile.getBrand()
            +" "+mobile.getModel()+"\">";
  }

    public String getExtMem() {
        return extMem;
    }

    public String getCamera() {
        return camera;
    }

    public String getSimCount() {
        return simCount;
    }

    public String[] getGps() {
        return gps;
    }

    public void setExtMem(String extMem) {
        this.extMem = extMem;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public void setSimCount(String[] simCount) {
        this.simCount = simCount[0];
    }

    public void setGps(String[] gps) {
        for(int i=0;i<gps.length;i++){
          if(gps[i]!=null && !gps[i].isEmpty()){this.gps[i]=gps[i];}
      }
    }
  
}
