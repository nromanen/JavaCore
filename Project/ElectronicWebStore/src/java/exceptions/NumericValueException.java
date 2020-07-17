/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;
import java.io.Serializable;
/**
 *
 * @author dmytr
 */
public class NumericValueException extends NumberFormatException implements Serializable {
   public NumericValueException(){
     super("You had entered wrong parameters for some numeric value");
   } 
   public NumericValueException(String str){
     super(str);
   }
}
