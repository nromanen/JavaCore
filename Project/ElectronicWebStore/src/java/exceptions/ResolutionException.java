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
public class ResolutionException extends IllegalArgumentException implements java.io.Serializable{
  public ResolutionException(){
    super("You had entered invalid resolution");
  }  
}
