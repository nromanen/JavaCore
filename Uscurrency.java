package Lesson7;

import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Uscurrency {

    public static void main(String[] args) {

        System.out.println("Dear user !!! Please enter several US currency:");
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();

        Pattern p=Pattern.compile("\\$(\\d*)(\\.\\d{2})?");
        Matcher m=p.matcher(text);

        ArrayList<String> occurence=new ArrayList();

        while(m.find()){
                occurence.add(text.substring(m.start(),m.end()));
            }

        for(String s:occurence){
                System.out.println("You enter such US currency : " + s);
                 }
        System.out.println(" Thank you !!! Good day !!! ");
        }

    }

