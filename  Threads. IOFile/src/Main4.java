import java.io.*;
import java.util.*;
//Create file1.txt file with a text about your career.
//        Read context from file into array of strings. Each array item contains one line from file.
//        Write in to the file2.txt
//        1) number of lines in file1.txt.
//        2) the longest line in file1.txt.
//        3) your name and birthday date.

public class Main4 {
    private String[] arr;

    public Main4() {
        createFile();
        this.arr = this.createArray();
    }

    private void createFile() {
        long count = 0;
        try {
            File file = new File("file1.txt");
            PrintWriter writer = new PrintWriter(file, "UTF-8");

            Random random = new Random();
            for (int i = 0; i < 2361; i++) {
                char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
                count += word.length;
                for (int j = 0; j < word.length; j++) {
                    word[j] = (char) ('a' + random.nextInt(26));

                }
                writer.print(new String(word) + ' ');
                count += 1;
                if (i % 10 == 0) {
                    writer.println();
                    count += 2;

                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String[] createArray() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("file1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<>();
        while (true) {
            assert sc != null;
            if (!sc.hasNextLine()) break;
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    private String infoFile() {
        int longest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > arr[longest].length()) {
                longest = i;
            }
        }
        return "File contain " + (arr.length + 1) + " lines, the longest line- " + longest;
    }

    public void arrayInTo() throws IOException {
        PrintWriter writer = new PrintWriter("file2.txt");

        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i] + ",");
            writer.println();
        }
        writer.write(infoFile());
        writer.close();

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Main4 main4 = new Main4();
        main4.arrayInTo();

    }


}