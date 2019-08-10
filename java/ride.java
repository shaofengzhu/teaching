/*
ID: shaofen1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String comet = in.readLine();
        String group = in.readLine();
        int cometNumber = calculateNumber(comet);
        int groupNumber = calculateNumber(group);
        if (cometNumber == groupNumber) {
            out.println("GO");
            // System.out.println("GO");
        }
        else {
            out.println("STAY");
            // System.out.println("STAY");
        }
        in.close();
        out.close();
    }

    private static int calculateNumber(String str) {
        int product = 1;
        for (int i = 0; i < str.length(); i++) {
            product = product * (str.charAt(i)  - 'A' + 1);
        }
        return product % 47;
    }
}
