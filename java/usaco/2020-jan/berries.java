/*
TASK: berries
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class berries {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new FileWriter("berries.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int treeCount = Integer.parseInt(st.nextToken());
        int bucketCount = Integer.parseInt(st.nextToken());

        int[] berryCountOnTrees = new int[treeCount];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < treeCount; i++) {
            berryCountOnTrees[i] = Integer.parseInt(st.nextToken());
        }

        int[] berryCountInBucket = new int[bucketCount];
        int[] berrySourceTreeInBucket = new int[bucketCount];

        for (int treeIndex = 0; treeIndex < treeCount; treeIndex++) {
            for (int berryIndex = 0; berryIndex < berryCountOnTrees[treeIndex]; berryIndex++) {
                for (int bucketIndex = 0; bucketIndex < bucketCount; bucketIndex++) {
                    berryCountInBucket[bucketIndex]++;
                }
            }
        }

        in.close();
        out.close();
    }
    
}
