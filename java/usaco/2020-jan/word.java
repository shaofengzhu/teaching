/*
TASK: word
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class word {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));

        StringTokenizer st1 = new StringTokenizer(in.readLine());
        int wordCount = Integer.parseInt(st1.nextToken());
        int maxLineLength = Integer.parseInt(st1.nextToken());


        StringTokenizer st2 = new StringTokenizer(in.readLine());
        int currentLineLength = 0;
        for (int i = 0; i < wordCount; i++) {
            String word = st2.nextToken();
            String wordToAppend = word;
            if (currentLineLength > 0) {
                wordToAppend = " " + word;
            }

            if (currentLineLength + word.length() <= maxLineLength) {
                out.print(wordToAppend);
                currentLineLength += word.length();
            }
            else {
                out.println();
                out.print(word);
                currentLineLength = word.length();
            }
        }

        in.close();
        out.close();
    }
}
