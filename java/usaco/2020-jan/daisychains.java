import java.io.*;
import java.util.*;


public class daisychains {

    public static void main(String[] args) throws IOException {
        BufferedReader input;
        // input = new BufferedReader(new FileReader("daisychains.in"));
        input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int flowerCount = Integer.parseInt(st.nextToken());
        int[] flowers = new int[flowerCount];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < flowerCount; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        int totalAverageFlowerPhoto = 0;

        for (int i = 0; i < flowerCount; i++) {
            for (int j = i; j < flowerCount; j++) {
                int total = 0;
                int count = 0;
                for (int k = i; k <= j; k++) {
                    total += flowers[k];
                    count++;
                }

                if (total % count == 0) {
                    int average = total / count;
                    boolean hasAverage = false;
                    for (int k = i; k <= j; k++) {
                        if (flowers[k] == average) {
                            hasAverage = true;
                            break;
                        }
                    }
                    if (hasAverage) {
                        totalAverageFlowerPhoto++;
                    }
                }
            }
        }

        System.out.println(totalAverageFlowerPhoto);

        input.close();

    }
    
}
