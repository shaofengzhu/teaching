import java.io.*;
import java.util.*;

public class stall1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        //input = new BufferedReader(new FileReader("stall.in"));
        input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        int[] cowHeight = new int[cowCount];
        for (int i = 0; i < cowCount; i++) {
            cowHeight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(input.readLine());
        int[] maxHeight = new int[cowCount];
        for (int i = 0; i < cowCount; i++) {
            maxHeight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cowHeight);
        for (int i = 0, j = cowHeight.length -1; i < j ; i++, j--) {
            int temp = cowHeight[i];
            cowHeight[i] = cowHeight[j];
            cowHeight[j] = temp;
        }

        Arrays.sort(maxHeight);
        for (int i = 0, j = maxHeight.length -1; i < j ; i++, j--) {
            int temp = maxHeight[i];
            maxHeight[i] = maxHeight[j];
            maxHeight[j] = temp;
        }

        int[] possibleFit = new int[cowCount];

        for (int i = 0; i < cowCount; i++) {
            int fitCount = 0;
            for (int j = 0; j < cowCount; j++) {
                if (maxHeight[j] >= cowHeight[i]) {
                    fitCount++;
                }
            }

            possibleFit[i] = fitCount;
        }

        for (int i = 1; i < cowCount; i++) {
            possibleFit[i] -= i;
        }

        long totalCount = 1;
        for (int i = 0; i < cowCount; i++) {
            totalCount = totalCount * possibleFit[i];
        }

        System.out.println(totalCount);

        input.close();
    }
}
