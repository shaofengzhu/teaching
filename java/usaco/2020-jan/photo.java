/*
TASK: photo
LANG: JAVA
*/
import java.io.*;
import java.util.*;
public class photo {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("photo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int[] b = new int[cowCount-1];
        int[] a = new int[cowCount];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int a0 = 1; a0 <= cowCount; a0++) {
            a[0] = a0;
            for (int i = 1; i < cowCount; i++) {
                a[i] = b[i-1] - a[i-1];
            }

            // now check whether a is a permutation
            int foundTotal = 0;
            for (int i = 1; i <= cowCount; i++) {
                boolean found = false;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == i) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    foundTotal++;
                }
                else {
                    break;
                }
            }

            if (foundTotal == cowCount) {
                for (int i = 0; i < a.length; i++) {
                    if (i != 0) {
                        out.print(" ");
                    }
                    out.print(a[i]);
                }
                break;
            }
        }

        in.close();
        out.close();
    }
}
