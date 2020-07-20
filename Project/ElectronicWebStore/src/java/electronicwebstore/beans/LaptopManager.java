/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronicwebstore.beans;
import model.*;
import java.util.stream.Collectors;
import exceptions.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dmytr
 */
public class LaptopManager extends ScreenCommodityManager{
  private String[] operMem;
  private String intMem;
  
  public String filter() throws SQLException,StringFieldException,SimCountException{
    comms.add(new Laptop("Apple","Macbook",65000.00,15,"FULL_HD",32,1000));
    comms.add(new Laptop("Lenovo","Ideapad",15000.00,15,"FULL_HD",8,1000));
    comms.add(new Laptop("Asus","Zenbook",20000.00,15,"FULL_HD",12,256));
    comms.add(new Laptop("Acer","Swift",12000.00,15,"FULL_HD",8,500));
    comms.add(new Laptop("Lenovo","ThinkPad",25000.00,15,"FULL_HD",16,2000));
    //DataLoader data=new DataLoader();
    //comms.addAll(data.filterBy(Laptop.class));
    //data.close();
    filterByPriceRange();
    filterByScreenSize();
    filterByBrand();
    filterByResolution();
    filterByOperMem();
    filterByIntMem();
    String output=print(comms);
    dropValues();
    return output;
  }
  
  public String print(List<Commodity> comm){
    String result="";    
    for(int i=0;i<comms.size();i++){
      if((i==0) || (i%3==0)){result+="<div id=\"commodityRow\">";}
      result+="<div class=\"comm"+comms.get(i).getId()+"\" id=\"commodity\">"+addImage((Laptop)comms.get(i))+
              ((Laptop)comms.get(i)).toHTML()+"</div>";
      if(((i+1)%3==0 && i>0) || (i==(comms.size()-1))){result+="</div>";}
    }
    return result;
  }
  public void filterByOperMem(){
    if(operMem!=null && operMem.length>0){
      comms=comms.stream().filter(c->isChecked(c))
              .collect(Collectors.toList());
    }
  }
  private boolean isChecked(Commodity comm){    
    for(String s:operMem){
      if(((Laptop)comm).getOperMem()==Integer.parseInt(s)){
          return true;
      }
    }
    return false;
  }
  public void filterByIntMem(){
    if(intMem!=null && !intMem.equals("All")){
      comms=comms.stream().filter(c->((Laptop)c).getIntMem()==Integer.parseInt(intMem))
              .collect(Collectors.toList());
    }
  }
  private void dropValues(){
    comms=new ArrayList();
    operMem=null;        
  }
  
  private String addImage(Laptop laptop){
    return "<img src=\"images\\laptop-"+laptop.getBrand().toLowerCase()+
              ".jpg\" alt=\""+laptop.getBrand()+" "+laptop.getModel()+"\">";
  }
  
    public String[] getOperMem() {
        return operMem;
    }

    public String getIntMem() {
        return intMem;
    }

    public void setOperMem(String[] operMem) {
        this.operMem = operMem;
    }

    public void setIntMem(String intMem) {
        this.intMem = intMem;
    }
  
}
