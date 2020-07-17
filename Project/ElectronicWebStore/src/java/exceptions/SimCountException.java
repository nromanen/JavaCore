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
public class SimCountException extends Exception implements java.io.Serializable {
  public SimCountException(String str){
    super(str);
  } 
  public SimCountException(){
    super("Number of simcards should be 1 or 2");
  }
}
