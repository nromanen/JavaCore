/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author dmytr
 */
public class BooleanException extends Exception implements java.io.Serializable{
  public BooleanException(String str){
      super("Value for "+str+" should be true or false");
  } 
  public BooleanException(){
      super("Value should be true or false");
  }
}
