/*
TASK: swap
LANG: JAVA
*/

import java.io.*;
import java.util.*;

public class swap {
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        // PrintWriter out = new PrintWriter(new FileWriter("swap.out"));

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(in.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int processCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int AStart = Integer.parseInt(st.nextToken());
        int AEnd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int BStart = Integer.parseInt(st.nextToken());
        int BEnd = Integer.parseInt(st.nextToken());

        int[] cows = new int[cowCount];
        for (int i = 0; i < cowCount; i++) {
            cows[i] = i + 1;
        }

        for (int i = 0; i < processCount; i++) {
            swapCows(cows, AStart, AEnd);
            swapCows(cows, BStart, BEnd);
        }

        for (int i = 0; i < cowCount; i++) {
            out.println(cows[i]);
        }

        in.close();
        out.close();
    }

    static void swapCows(int[] cows, int start, int end) {
        start = start -1;
        end = end -1;
        while (start < end) {
            int temp = cows[start];
            cows[start] = cows[end];
            cows[end] = temp;
            start++;
            end--;
        }
    }
    
}
