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
import model.*;
/**
 *
 * @author dmytr
 */
public class AccesorieManager extends CommodityManager {
  private String[] names;
  public String filter() throws SQLException,StringFieldException,SimCountException{
    comms.add(new Accesorie("Earphones","KOSS","GE40",500.00,"Great earphones"));
    comms.add(new Accesorie("Keyboard","Logitech","K40",900.00,"Great keyboard"));
    comms.add(new Accesorie("Bag for laptop","Belkin","P1",600.00,"Good bag"));
    comms.add(new Accesorie("Computer mouse","Logitech","M180",600.00,"Great mouse"));
    //DataLoader data=new DataLoader();
    //comms.addAll(data.filterBy(Accesorie.class));
    //data.close();
    filterByPriceRange();    
    filterByBrand();
    filterByName();
    String output=print(comms);
    dropValues();
    return output;
  }
  public String print(List<Commodity> comm){
    String result="";    
    for(int i=0;i<comms.size();i++){
      if((i==0) || (i%3==0)){result+="<div id=\"commodityRow\">";}
      result+="<div class=\"comm"+comms.get(i).getId()+"\" id=\"commodity\">"+addImage((Accesorie)comms.get(i))+
              ((Accesorie)comms.get(i)).toHTML()+"</div>";
      if(((i+1)%3==0 && i>0) || (i==(comms.size()-1))){result+="</div>";}
    }
    return result;
  }
  public void filterByName(){
    if(names!=null && names.length>0){
      comms=comms.stream().filter(c->isChecked(c)).collect(Collectors.toList());
    }
  }
  private boolean isChecked(Commodity comm){    
    for(String s:names){
      if(((Accesorie)comm).getName().equals(s)){
          return true;}
    }
    return false;
  }
  private void dropValues(){
    comms=new ArrayList();
    names=null;
  }
  
  private String addImage(Accesorie acc){
    return "<img src=\"images\\acc-"+acc.getName().toLowerCase()+
              ".jpg\" alt=\""+acc.getName()+" "+acc.getBrand()+" "
              +acc.getModel()+"\">";
  }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
  
}
