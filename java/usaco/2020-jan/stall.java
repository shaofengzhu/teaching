import java.io.*;
import java.util.*;

public class stall {
    static int totalCount = 0;
    static int permuteCount = 0;
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

        int[] assigns = new int[cowCount];
        for (int i = 0; i < cowCount; i++) {
            assigns[i] = i;
        }

        totalCount = 0;

        permuate(cowHeight, maxHeight, assigns, 0, assigns.length -1);

        System.out.println(totalCount);
        // System.out.println(permuteCount);

        input.close();
    }

    static void permuate(int[] cowHeight, int[] maxHeight, int[] assigns, int left, int right) {

        if (!meetHeightRequirement(cowHeight, maxHeight, assigns, left + 1)) {
             return;
        }

        permuteCount++;

        if (left == right) {
            totalCount++;
            // boolean shouldCount = meetHeightRequirement(cowHeight, maxHeight, assigns, cowHeight.length);
            // if (shouldCount) {
            //     totalCount++;
            // }
        }
        else {
            for (int i = left; i<= right; i++) 
            {        
                swap(assigns, left, i);
                permuate(cowHeight, maxHeight, assigns, left + 1, right);
                swap(assigns, left, i);
            }
        }
    }

    static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    static boolean meetHeightRequirement(int[] cowHeight, int[] maxHeight, int[] assigns, int elementCount) {
        for (int i = elementCount -1; i >= 0; i--) {
            int assignPosition = assigns[i];
            if (cowHeight[i] > maxHeight[assignPosition]) {
                return false;
            }
        }

        return true;
    }
}

