import java.io.*;
import java.util.*;
public class reststops {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter output = new PrintWriter(new FileWriter("reststops.out"));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int totalLength = Integer.parseInt(st.nextToken());
        int stopCount = Integer.parseInt(st.nextToken());
        int farmerSecondsPerMeter = Integer.parseInt(st.nextToken());
        int bessieSecondsPerMeter = Integer.parseInt(st.nextToken());

        long[] positions = new long[stopCount];
        long[] tastiness = new long[stopCount];

        for (int i = 0; i < stopCount; i++) {
            st = new StringTokenizer(input.readLine());
            positions[i] = Long.parseLong(st.nextToken());
            tastiness[i] = Long.parseLong(st.nextToken());
        }

        boolean[] isMax = new boolean[stopCount];
        long max = 0;
        for (int i = stopCount -1; i >= 0; i--) {
            if (tastiness[i] > max) {
                isMax[i] = true;
                max = tastiness[i];
            }
        }

        for (int i = 0; i < stopCount; i++) {
            if (isMax[i]) {
                System.out.println("Stop:" + positions[i]);
            }
        }
        

        long previousPosition = 0;
        long totalTastiness = 0;

        for (int i = 0; i < stopCount; i++) {
            if (isMax[i]) {
                long position = positions[i];
                long waitTime = (position - previousPosition) * (farmerSecondsPerMeter - bessieSecondsPerMeter);
                long gain = waitTime * tastiness[i];
                System.out.println(gain);
                totalTastiness += gain;
                previousPosition = position;    
            }
        }

        output.println(totalTastiness);

        input.close();
        output.close();
    }

    static int getNextBestStop(long[] tastiness, long[] positions, int startIndex, long previousPosition) {
        long[] tastinessGain = new long[tastiness.length];
        for (int i = startIndex; i< tastiness.length; i++) {
            tastinessGain[i] = (positions[i] - previousPosition) * tastiness[i];
        }

        int bestStopIndex = startIndex;
        for (int i = startIndex; i < tastiness.length; i++) {
            if (tastinessGain[bestStopIndex] < tastinessGain[i]) {
                bestStopIndex = i;
            }
        }

        return bestStopIndex;
    }
}
