package Lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiveWords2 {

    public static void main(String[] args) throws IOException {

        // Entering the words in console

        System.out.println(" Hello Dear user please enter Your words : ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String words = reader.readLine();

        System.out.println("Hello Dear user you enter such words: " + words);

        // Spliting String on words

        String stringEnter = words;

        String[] stringParts = stringEnter.split(" ");

        // Count how many words enter user and what is this words

        System.out.println("You enter " + stringParts.length + " words. ");

        for (int a = 0; a < stringParts.length; a++)

            System.out.println(" Word № " + a + " - " + stringParts[a]);

        // Count the Longest word letters ant print it on the screen

        String longestWord = stringParts[0];

        for (int i = 1; i < stringParts.length; i++) {
            if (longestWord.length() < stringParts[i].length())
                longestWord = stringParts[i];
        }

        System.out.println("The longestword is " + longestWord);
        System.out.println("The lenght of the longest word is = " + longestWord.length() + " letters ");

        // split SecondWord on letters

        String SecondWord = stringParts[1];

        char[] letters = stringParts[1].toCharArray();

        System.out.println("Second word has " + letters.length + " letters");

        //reverse the letters in Second word

        StringBuffer word = new StringBuffer(SecondWord);

        word.reverse();

        System.out.println("Anagrama of Second word is: " + word);
    }
}