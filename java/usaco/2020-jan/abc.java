import java.io.*;
import java.util.*;

public class abc {

    public static void main(String[] args) throws IOException {
        BufferedReader input;
        // input = new BufferedReader(new FileReader("abc.in"));
        input = new BufferedReader(new InputStreamReader(System.in));

        int[] values = new int[7];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        int a_b_c = values[6];
        int a = values[0];
        int b = values [1];
        int c = a_b_c - a - b;

        System.out.print(a);
        System.out.print(" ");
        System.out.print(b);
        System.out.print(" ");
        System.out.println(c);

        input.close();

    }
    
}
