//Tasks*** 1
// Given three integers a, b, c. Return the larges number obtained after inserting the following operators and brackets: +, *, ().
//The numbers are always positive.
//The numbers are in the range 1 <= a,b,c <=10.
//You can use the same operation more than once. // 1+ 2+ 3      1*2*3.     1+2*3
//It’s not necessary to place all the signs and brackets.
//Repetition in numbers may occur.
//You can’t swap the operands.

import java.util.*;

public class ConsoleAplicationTask3 {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int a = rand.nextInt(11);
        int b = rand.nextInt(11);
        int c = rand.nextInt(11);
        if ((a > 0) & (b > 0) & (c > 0)) {

            List<Integer> list = new LinkedList<>();
            list.add((a + b + c));
            list.add((a + b * c));
            list.add((a * b + c));
            list.add((a * b * c));
            list.add((a * b + c));
            list.add(a * (b + c));
            list.add((a + b) * c);
            Collections.sort(list);


            System.out.println("The largest number after following expressions^: a * (b + c);  a + b * c; a * b + c; a * b * c; a * b + c; a * (b + c) is - " + list.get(6));

        } else {
            throw new Exception("Invalid Data");
        }
    }
}