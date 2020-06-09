/*Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
realizing the operations of union and intersection of two sets.
Test the operation of these techniques on two pre-filled sets.

 Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
 Output the entities of the map on the screen.
 There are at less two persons with the same firstName among these 10 people?
 Remove from the map person whose firstName is &rdquo;Orest&rdquo; (or other). Print result.
*/


//        List animals = new ArrayList();
//        Animal ourAnimal = new Animal ();
//        animals.add("cat");
//        animals.add("dog");
//        animals.add("hors");
//        String animal = (String) animals.get();
//        System.out.println(animals);
package lesson5;

import java.util.List;
import java.util.ArrayList;
public class Generic {
    public static String longerName(String name1, String name2){
      if (name1.compareTo(name2)>0) {
       // if (name1.length()>name2.length())
          System.out.println(name1);
          return name1;
        }
        System.out.println(name2);
     return name2;
    }
    public static void main(String[] args) {

       List <String> animals2 = new ArrayList<String>();
       animals2.add("cat");
       animals2.add("dogger");
       animals2.add("hors");
       //System.out.println (

           longerName(animals2.get(1), animals2.get(2));

//       String q = animals2.get(0);
//       System.out.println(q);


    }
}
