/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import model.*;
import exceptions.*;
import java.util.stream.Collectors;
import java.io.Serializable;
/**
 *
 * @author dmytr
 */
public class DataLoader {
   private Connection conn=null;
   private Statement stat=null;
   private PreparedStatement prepStat=null;
   private ResultSet resultSet=null;
   
   public List<Commodity> loadData() throws SQLException,StringFieldException,SimCountException{
     List<Commodity> store=new ArrayList();
     conn=createConnection();
     stat=conn.createStatement();
     store.addAll(loadTVs());
     store.addAll(loadMobiles());
     store.addAll(loadLaptops());
     store.addAll(loadAccesories());
     close();
     return store;
   }
   //TO DO divide on smaller adds and add createCon
   public void addData(Commodity comm) throws SQLException{
     conn=createConnection();
     stat=conn.createStatement();
     if(!isBrand(comm.getBrand())){
         stat.executeUpdate("INSERT INTO BRANDS(BRAND) VALUES ("+"\'"+comm.getBrand()+"\'"+")");
     }
     resultSet=stat.executeQuery("SELECT ID FROM BRANDS WHERE BRAND="+"\'"+comm.getBrand()+"\'");
     int idBrand=0;
     while(resultSet.next()){
       idBrand=resultSet.getInt("ID");
       break;
     }
     if(comm instanceof Television){addTv(comm,idBrand);}
     if(comm instanceof MobileDevice){addMobile(comm,idBrand);}
     if((comm instanceof Laptop) && !(comm instanceof MobileDevice)){addLaptop(comm,idBrand);}
     if(comm instanceof Accesorie){addAccesorie(comm,idBrand);}
     close();     
   }
   //a
    public List<Commodity> filterBy(Class type) throws SQLException,StringFieldException,SimCountException {
        List<Commodity> store=new ArrayList();
        conn=createConnection();
        stat=conn.createStatement();
        if(type.equals(Television.class)){return loadTVs();}
        if(type.equals(Laptop.class)){return loadLaptops();}
        if(type.equals(MobileDevice.class)){return loadMobiles();}
        if(type.equals(Accesorie.class)){return loadAccesories();}
        throw new IllegalArgumentException("Wrong type");        
    }
    
    public List<Commodity> getOfPriceRange(int minPrice,int maxPrice) throws SQLException,StringFieldException,SimCountException{
      conn=createConnection();
      stat=conn.createStatement(); 
      List<Commodity> comms=new ArrayList();           
      comms.addAll(getTvOfPriceRange(minPrice, maxPrice)); 
      comms.addAll(getMobileOfPriceRange(minPrice, maxPrice));            
      comms.addAll(getLaptopOfPriceRange(minPrice, maxPrice));
      comms.addAll(getAccesoriesOfPriceRange(minPrice, maxPrice));
      close();
      return comms;
    }  
    
    public List<Commodity> getOfBrand(String brand) throws SQLException,
            StringFieldException,SimCountException{
      List<Commodity> commOfBrand=new ArrayList();
      conn=createConnection();
      stat=conn.createStatement();      
      commOfBrand.addAll(getTvOfBrand(brand));      
      commOfBrand.addAll(getMobileOfBrand(brand));      
      commOfBrand.addAll(getLaptopOfBrand(brand));      
      commOfBrand.addAll(getAccesorieOfBrand(brand));
      close();
      return commOfBrand;
    }    
    
    public Television getTvById(int id) throws SQLException,StringFieldException{
      conn=createConnection();
      stat=conn.createStatement();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN TV ON BRANDS.ID=TV.ID_BRAND "
              + "WHERE TV.ID="+id);
      Television tv=(Television)resultSetToTv(resultSet).get(0);
      close();
      return tv;
    }
    
    public MobileDevice getMobileById(int id) throws SQLException,StringFieldException,
            SimCountException{
      conn=createConnection();
      stat=conn.createStatement();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN MOBILE_DEVICES ON "
              + "BRANDS.ID=MOBILE_DEVICES.ID_BRAND WHERE MOBILE_DEVICES.ID="+id);
      MobileDevice mobile=(MobileDevice)resultSetToMobile(resultSet).get(0);
      close();
      return mobile;
    }
    
    public Laptop getLaptopById(int id) throws SQLException,StringFieldException{
      conn=createConnection();
      stat=conn.createStatement();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN  ON "
              + "BRANDS.ID=LAPTOPS.ID_BRAND WHERE LAPTOPS.ID="+id);
      Laptop laptop=(Laptop)resultSetToLaptop(resultSet).get(0);
      close();
      return laptop;
    }
    
    public Accesorie getAccesorieById(int id) throws SQLException,StringFieldException{
      conn=createConnection();
      stat=conn.createStatement();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN ACCESORIES ON "
              + "BRANDS.ID=ACCESORIES.ID_BRAND WHERE ACCESORIES.ID="+id);
      Accesorie acc=(Accesorie)resultSetToAccesories(resultSet).get(0);
      close();
      return acc;
    }
    
    public void update(Commodity comm) throws SQLException{
      conn=createConnection();
      if(comm instanceof Television){updateTv((Television)comm);}
      if(comm instanceof MobileDevice){updateMobile((MobileDevice)comm);}
      if((comm instanceof Laptop) && !(comm instanceof MobileDevice)){
          updateLaptop((Laptop)comm);}
      if(comm instanceof Accesorie){updateAccesorie((Accesorie)comm);}
      close();
    } 
        
    public void delete(Commodity comm) throws SQLException{
      conn=createConnection();
      stat=conn.createStatement();
      if(comm instanceof Television){
        stat.executeUpdate("DELETE FROM TV WHERE ID="+comm.getId());
      }
      if(comm instanceof MobileDevice){
        stat.executeUpdate("DELETE FROM MOBILE_DEVICES WHERE ID="+comm.getId());
      }
      if((comm instanceof Laptop) && !(comm instanceof MobileDevice)){
        stat.executeUpdate("DELETE FROM LAPTOPS WHERE ID="+comm.getId());
      }
      if(comm instanceof Accesorie){
        stat.executeUpdate("DELETE FROM ACCESORIES WHERE ID="+comm.getId());
      }
      close();
    }
    private Connection createConnection() throws SQLException{
      return DriverManager.getConnection("jdbc:mysql://localhost/ELECTRONIC_STORE?"
              + "useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC",
                "Dmytro","Danylov20#");
    }
    public void close() throws SQLException{
      if(resultSet!=null){resultSet.close();}
      if(stat!=null){stat.close();}
      if(prepStat!=null){prepStat.close();}
      if(conn!=null){conn.close();}
    }
    private boolean isBrand(String brand) throws SQLException{
      resultSet=stat.executeQuery("SELECT * FROM BRANDS");
      while(resultSet.next()){
        if(brand.toUpperCase().equals(resultSet.getString("BRAND").toUpperCase())){
          return true;
        }
      }     
      return false;
   }
    private List<Commodity> loadTVs() throws SQLException,StringFieldException {            
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN TV ON BRANDS.ID=TV.ID_BRAND");     
      return resultSetToTv(resultSet);
    } 
    private List<Commodity> loadMobiles() throws SQLException,StringFieldException,SimCountException {          
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN MOBILE_DEVICES ON "
             + "BRANDS.ID=MOBILE_DEVICES.ID_BRAND");     
      return resultSetToMobile(resultSet);
    }
    private List<Commodity> loadLaptops() throws SQLException,StringFieldException {         
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN LAPTOPS ON BRANDS.ID=LAPTOPS.ID_BRAND");     
      return resultSetToLaptop(resultSet);
    }
    private List<Commodity> loadAccesories() throws SQLException,StringFieldException{          
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN ACCESORIES ON BRANDS.ID=ACCESORIES.ID_BRAND");     
      return resultSetToAccesories(resultSet);
    }
    private List<Commodity> resultSetToTv(ResultSet resultSet) throws SQLException,StringFieldException{
      List<Commodity> tvs=new ArrayList();
      while(resultSet.next()){
        Television tv=new Television();
        tv.setBrand(resultSet.getString("BRAND"));
        tv.setModel(resultSet.getString("MODEL"));
        tv.setPrice(Double.valueOf(resultSet.getString("PRICE")));
        tv.setScreenSize(Integer.parseInt(resultSet.getString("SCREENSIZE")));
        tv.setRes(resultSet.getString("RESOLUTION"));
        if(resultSet.getString("SMART_TV").equals("1")){tv.setSmartTv(true);}
        else{tv.setSmartTv(false);}
        if(resultSet.getString("3d").equals("1")){tv.setThreeD(true);}
        else{tv.setThreeD(false);}
        tv.setId(resultSet.getInt("TV.ID"));
        tvs.add(tv);
     }
     return tvs;
    }
    private List<Commodity> resultSetToMobile(ResultSet resultSet) throws SQLException,StringFieldException,SimCountException{
      List<Commodity> mobileDevices=new ArrayList();
      while(resultSet.next()){
       MobileDevice mobile=new MobileDevice();
       mobile.setBrand(resultSet.getString("BRAND"));
       mobile.setModel(resultSet.getString("MODEL"));
       mobile.setPrice(Double.valueOf(resultSet.getString("PRICE")));
       mobile.setScreenSize(Integer.parseInt(resultSet.getString("SCREENSIZE")));
       mobile.setRes(resultSet.getString("RESOLUTION"));
       mobile.setOperMem(Integer.parseInt(resultSet.getString("OPERATING_MEMORY")));
       mobile.setIntMem(Integer.parseInt(resultSet.getString("INTERNAL_MEMORY")));
       mobile.setExtMem(Integer.parseInt(resultSet.getString("EXTERNAL_MEMORY")));
       mobile.setSimCount(Integer.parseInt(resultSet.getString("SIM_COUNT")));
       mobile.setCamera(Integer.parseInt(resultSet.getString("CAMERA")));
       if(resultSet.getString("GPS").equals("1")){mobile.setGps(true);}
       else{mobile.setGps(false);}
       mobile.setId(resultSet.getInt("MOBILE_DEVICES.ID"));
       mobileDevices.add(mobile);
     }
     return mobileDevices;
    }
    private List<Commodity> resultSetToLaptop(ResultSet resultSet) throws SQLException,StringFieldException{
      List<Commodity> laptops=new ArrayList();
      while(resultSet.next()){
        Laptop laptop=new Laptop();
        laptop.setBrand(resultSet.getString("BRAND"));
        laptop.setModel(resultSet.getString("MODEL"));
        laptop.setPrice(Double.valueOf(resultSet.getString("PRICE")));
        laptop.setScreenSize(Integer.parseInt(resultSet.getString("SCREENSIZE")));
        laptop.setRes(resultSet.getString("RESOLUTION"));
        laptop.setOperMem(Integer.parseInt(resultSet.getString("OPERATING_MEMORY")));
        laptop.setIntMem(Integer.parseInt(resultSet.getString("INTERNAL_MEMORY")));
        laptop.setId(resultSet.getInt("LAPTOPS.ID"));
        laptops.add(laptop);       
     }
     return laptops;
    }
    private List<Commodity> resultSetToAccesories(ResultSet resultSet) throws SQLException,StringFieldException{
      List<Commodity> accesories=new ArrayList();
      while(resultSet.next()){
        Accesorie acc=new Accesorie();
        acc.setBrand(resultSet.getString("BRAND"));
        acc.setModel(resultSet.getString("MODEL"));
        acc.setPrice(Double.valueOf(resultSet.getString("PRICE")));
        acc.setName(resultSet.getString("NAME"));
        acc.setShortDescription(resultSet.getString("SHORT_DESCRIPTION"));
        acc.setId(resultSet.getInt("ACCESORIES.ID"));
        accesories.add(acc);
     }
     return accesories;
    }
    private void addTv(Commodity comm, int idBrand) throws SQLException{      
        int smartTv=0;
        int threeD=0;       
        if(((Television)comm).isSmartTv()){smartTv++;}
        if(((Television)comm).isThreeD()){threeD++;}
        stat.executeUpdate("INSERT INTO TV(MODEL,PRICE,SCREENSIZE,RESOLUTION,ID_BRAND,SMART_TV,3D)"
               + " VALUES ("+"\'"+comm.getModel()+"\'"+","+comm.getPrice()+","+(int)((Television) comm)
               .getScreenSize()+","+"\'"+((Television) comm).getRes()+"\'"+","+idBrand+","
                +smartTv+","+threeD+")");     
    }
    private void addMobile(Commodity comm, int idBrand) throws SQLException{      
        int gps=0;
        if(((MobileDevice)comm).isGps()){gps++;}       
        stat.executeUpdate("INSERT INTO MOBILE_DEVICES(MODEL,PRICE,SCREENSIZE,RESOLUTION,"
               + "ID_BRAND,OPERATING_MEMORY,INTERNAL_MEMORY,EXTERNAL_MEMORY,SIM_COUNT,CAMERA,GPS) VALUES"
               + " ("+"\'"+comm.getModel()+"\'"+","+comm.getPrice()+","+((MobileDevice) comm)
               .getScreenSize()+","+"\'"+((MobileDevice) comm).getRes()+"\'"+","+idBrand+","+
                ((MobileDevice) comm).getOperMem()+","+((MobileDevice) comm).getIntMem()+","+
                ((MobileDevice) comm).getExtMem()+","+((MobileDevice) comm).getSimCount()+","+
                ((MobileDevice) comm).getCamera()+","+gps+")");     
    }
    private void addLaptop(Commodity comm, int idBrand) throws SQLException{      
        stat.executeUpdate("INSERT INTO LAPTOPS(MODEL,PRICE,SCREENSIZE,"
                + "ID_BRAND,RESOLUTION,OPERATING_MEMORY,INTERNAL_MEMORY) VALUES ("+
               "\'"+comm.getModel()+"\'"+","+comm.getPrice()+","+((Laptop) comm).getScreenSize()+
               ","+idBrand+","+"\'"+((Laptop) comm).getRes()+"\'"+","+((Laptop) comm).getOperMem()+","+
               ((Laptop) comm).getIntMem()+")");     
    }
    private void addAccesorie(Commodity comm, int idBrand) throws SQLException{      
       stat.executeUpdate("INSERT INTO ACCESORIES(MODEL,PRICE,NAME,SHORT_DESCRIPTION,ID_BRAND) VALUES ("+
               "\'"+comm.getModel()+"\'"+","+comm.getPrice()+","+"\'"+((Accesorie) comm).getName()+"\'"+
               ","+"\'"+((Accesorie) comm).getShortDescription()+"\'"+","+idBrand+")");       
    }
    
    
    public List<Commodity> getTvOfPriceRange(int minPrice,int maxPrice) throws SQLException,StringFieldException{
      List<Commodity> comms=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN TV ON BRANDS.ID=TV.ID_BRAND "
             + "WHERE PRICE>"+minPrice+" AND PRICE<"+maxPrice);      
      comms.addAll(resultSetToTv(resultSet));
      return comms;
    }
    
    private List<Commodity> getMobileOfPriceRange(int minPrice,int maxPrice) 
            throws SQLException,StringFieldException,SimCountException{
      List<Commodity> comms=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN MOBILE_DEVICES ON "
              + "BRANDS.ID=MOBILE_DEVICES.ID_BRAND WHERE PRICE>"+minPrice+" AND "
                      + "PRICE<"+maxPrice);      
      comms.addAll(resultSetToMobile(resultSet));
      return comms;
    }
    
    private List<Commodity> getLaptopOfPriceRange(int minPrice,int maxPrice) 
            throws SQLException,StringFieldException{
      List<Commodity> comms=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN LAPTOPS ON "
              + "BRANDS.ID=LAPTOPS.ID_BRAND "
             +"WHERE PRICE>"+minPrice+" AND PRICE<"+maxPrice);      
      comms.addAll(resultSetToLaptop(resultSet));
      return comms;
    }
    
    private List<Commodity> getAccesoriesOfPriceRange(int minPrice,int maxPrice) throws SQLException,StringFieldException{
      List<Commodity> comms=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN ACCESORIES ON "
              + "BRANDS.ID=ACCESORIES.ID_BRAND WHERE PRICE>"+minPrice+" AND "
                      + "PRICE<"+maxPrice);      
      comms.addAll(resultSetToAccesories(resultSet));
      return comms;
    }
    
    private List<Commodity> getTvOfBrand(String brand)throws SQLException,
            StringFieldException{
      List<Commodity> tvOfBrand=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN TV ON BRANDS.ID=TV.ID_BRAND "
              + "WHERE BRAND="+"\'"+brand+"\'");
      tvOfBrand.addAll(resultSetToTv(resultSet));
      return tvOfBrand;
    }
    
    private List<Commodity> getMobileOfBrand(String brand)throws SQLException,
            StringFieldException,SimCountException{
      List<Commodity> mobileOfBrand=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN MOBILE_DEVICES ON "
              + "BRANDS.ID=MOBILE_DEVICES.ID_BRAND WHERE BRAND="+"\'"+brand+"\'");
      mobileOfBrand.addAll(resultSetToMobile(resultSet));
      return mobileOfBrand;
    }
    
    private List<Commodity> getLaptopOfBrand(String brand)throws SQLException,
            StringFieldException{
      List<Commodity> laptopOfBrand=new ArrayList();
      resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN LAPTOPS ON "
              + "BRANDS.ID=LAPTOPS.ID_BRAND WHERE BRAND="+"\'"+brand+"\'");
      laptopOfBrand.addAll(resultSetToLaptop(resultSet));
      return laptopOfBrand;
    }
    
    private List<Commodity> getAccesorieOfBrand(String brand)throws SQLException,
            StringFieldException{
      List<Commodity> accOfBrand=new ArrayList();
       resultSet=stat.executeQuery("SELECT * FROM BRANDS JOIN ACCESORIES ON "
              + "BRANDS.ID=ACCESORIES.ID_BRAND WHERE BRAND="+"\'"+brand+"\'");
      accOfBrand.addAll(resultSetToLaptop(resultSet));
      return accOfBrand;
    }
    
    private void updateTv(Television tv) throws SQLException{      
      prepStat=conn.prepareStatement("UPDATE TV SET MODEL=?,PRICE=?,SCREENSIZE=?,"
              + "RESOLUTION=?,SMART_TV=?,3D=? WHERE ID="+tv.getId());      
      int smartTv=0;
      int threeD=0;       
      if(((Television)tv).isSmartTv()){smartTv=1;}
      if(((Television)tv).isThreeD()){threeD=1;}
      prepStat.setString(1,tv.getModel());
       prepStat.setInt(2, (int)tv.getPrice());
      prepStat.setInt(3, (int)tv.getScreenSize());
      prepStat.setString(4, tv.getRes());
      prepStat.setInt(5, smartTv);
      prepStat.setInt(6, threeD);
      prepStat.executeUpdate();      
    }
    private void updateMobile(MobileDevice mobile) throws SQLException{      
      prepStat=conn.prepareStatement("UPDATE MOBILE_DEVICES SET MODEL=?,PRICE=?,"
              + "SCREENSIZE=?,RESOLUTION=?,OPERATING_MEMORY=?,INTERNAL_MEMORY=?,"
              + "EXTERNAL_MEMORY=?,CAMERA=?,SIM_COUNT=?,GPS=? WHERE ID="+mobile.getId());      
      int gps=0;       
      if(mobile.isGps()){gps=1;}
      prepStat.setString(1,mobile.getModel());
      prepStat.setInt(2, (int)mobile.getPrice());
      prepStat.setInt(3, (int)mobile.getScreenSize());
      prepStat.setString(4, mobile.getRes());
      prepStat.setInt(5, mobile.getOperMem());
      prepStat.setInt(6, mobile.getIntMem());
      prepStat.setInt(7, mobile.getExtMem());
      prepStat.setInt(8, mobile.getCamera());
      prepStat.setInt(9, mobile.getSimCount());
      prepStat.setInt(10, gps);
      prepStat.executeUpdate();      
    }
    
    private void updateLaptop(Laptop laptop) throws SQLException{      
      prepStat=conn.prepareStatement("UPDATE LAPTOPS SET MODEL=?,PRICE=?,SCREENSIZE=?,"
              + "RESOLUTION=?,OPERATING_MEMORY=?,INTERNAL_MEMORY=? WHERE ID="+
              laptop.getId());      
      prepStat.setString(1,laptop.getModel());
      prepStat.setInt(2, (int)laptop.getPrice());
      prepStat.setInt(3, (int)laptop.getScreenSize());
      prepStat.setString(4, laptop.getRes());
      prepStat.setInt(5, laptop.getOperMem());
      prepStat.setInt(6, laptop.getIntMem());
      prepStat.executeUpdate();
    }
    
    private void updateAccesorie(Accesorie acc) throws SQLException{
      prepStat=conn.prepareStatement("UPDATE ACCESORIES SET MODEL=?,PRICE=?,"
              + "NAME=?,SHORT_DESCRIPTION=? WHERE ID="+
              acc.getId());      
      prepStat.setString(1,acc.getModel());
      prepStat.setInt(2, (int)acc.getPrice());
      prepStat.setString(3, acc.getName());
      prepStat.setString(4, acc.getShortDescription());
      prepStat.executeUpdate();
    }
}
