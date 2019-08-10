/*
ID: shaofen1
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum = a + b;
        out.println(sum);
        out.close();
        in.close();
    }
}
