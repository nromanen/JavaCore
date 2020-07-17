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
public class StringFieldException extends Exception  implements java.io.Serializable{
  public StringFieldException(String field,int minLength,int maxLength){
    super("Length of field "+field+" should be between "+minLength+" and "+maxLength+" characters");
  } 
  public StringFieldException(String str){
    super(str);
  }
}
