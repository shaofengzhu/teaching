/*
ID: shaofen1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("beads.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        String necklaceString = st.nextToken();
        necklaceString = necklaceString.substring(0, length);
        char[] originalNecklace = necklaceString.toCharArray();

        int longest = 0;
        for (int i = 0; i < originalNecklace.length; i++) {
            char[] newNecklace = new char[originalNecklace.length];

            for (int j = 0; j < originalNecklace.length; j++) {
                newNecklace[j] = originalNecklace[(i + j) % originalNecklace.length];
            }

            int firstCount = 0;
            for (int j = 0; j < newNecklace.length; j++) {
                if (newNecklace[j] == 'w') {
                    firstCount++;
                }
                else {
                    break;
                }
            }

            if (firstCount < newNecklace.length) {
                char firstChar = newNecklace[firstCount];
                for (int j = firstCount; j < newNecklace.length; j++) {
                    if (newNecklace[j] == firstChar || newNecklace[j] == 'w') {
                        firstCount++;
                    }
                    else {
                        break;
                    }
                }
            }

            int lastCount = 0;
            for (int j = newNecklace.length -1; j >= firstCount; j--) {
                if (newNecklace[j] == 'w') {
                    lastCount++;
                }
                else {
                    break;
                }
            }

            if (newNecklace.length -1 - lastCount >= 0) {
                char lastChar = newNecklace[newNecklace.length -1 - lastCount];
                for (int j = newNecklace.length -1 - lastCount; j >= firstCount; j--) {
                    if (newNecklace[j] == lastChar || newNecklace[j] == 'w') {
                        lastCount++;
                    }
                    else {
                        break;
                    }
                }
            }

            // System.out.println("firstCount=" + firstCount + ", lastCount=" + lastCount);

            int totalCount = firstCount + lastCount;
            if (totalCount > longest) {
                longest = totalCount;
            }
        }

        output.println(longest);
        output.close();
        input.close();
    }
}
