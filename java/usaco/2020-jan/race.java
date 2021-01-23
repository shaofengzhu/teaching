/*
TASK: race
LANG: JAVA
*/
import java.io.*;
import java.util.*;

public class race {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("race.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int raceLength = Integer.parseInt(st.nextToken());
        int caseCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < caseCount; i++) {
            st = new StringTokenizer(in.readLine());
            int maxSpeed = Integer.parseInt(st.nextToken());
            int minimalTime = calcMinimalTime(raceLength, maxSpeed);
            out.println(minimalTime);

        }
        out.close();
        in.close();
    }

    private static int calcMinimalTime(int raceLength, int maxSpeed) {
        int sum = 0;
        int speed = 0;
        int count = 0;
        while (sum < raceLength) {
            speed++;
            sum = sum + speed;
            count++;
            if (sum < raceLength) {
                if (speed >= maxSpeed) {
                    sum += speed;
                    count++;
                }
            }
        }

        return count;
    }
}
