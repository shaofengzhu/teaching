import java.io.*;
import java.util.*;

public class cowalphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        //input = new BufferedReader(new FileReader("cowalphabet.in"));
        input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine().trim();
        char[] letters = str.toCharArray();

        String word = input.readLine().trim();
        char[] wordChars = word.toCharArray();

        int count = 1;
        int start = 0;
        for (int i = 0; i < wordChars.length; i++) {
            int foundIndex = -1;
            do {
                foundIndex = -1;
                for (int j = start; j < letters.length; j++) {
                    if (letters[j] == wordChars[i]) {
                        foundIndex = j;
                        break;
                    }
                }

                if (foundIndex < 0) {
                    count++;
                    start = 0;
                }
                else {
                    start = foundIndex + 1;
                }
            }while(foundIndex < 0);
        }

        System.out.println(count);

        input.close();
    }
}
