import java.io.*;
import java.util.*;
public class meetings {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter output = new PrintWriter(new FileWriter("meetings.out"));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int[] weights = new int[cowCount];
        double[] positions = new double[cowCount];
        int[] speeds = new int[cowCount];

        int totalWeigth = 0;

        for (int i = 0; i < cowCount; i++) {
            st = new StringTokenizer(input.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            positions[i] = Integer.parseInt(st.nextToken());
            speeds[i] = Integer.parseInt(st.nextToken());

            if (floatEqual(positions[i], 0)) {
                speeds[i] = 0;
            }
            else if (floatEqual(positions[i], distance)) {
                speeds[i] = 0;
            }

            totalWeigth+= weights[i];
        }

        sort(cowCount, positions, speeds, weights);

        int barnWeight = calculateBarnWeight(cowCount, weights, positions, speeds, distance);
        int totalMeetingCount = 0;
        int loopCount = 0;
        while (2 * barnWeight < totalWeigth) {
            double time = nextMeetingTime(cowCount, positions, speeds, distance);
            if (floatEqual(time, 0)) {
                throw new RuntimeException("Unexpected");
            }

            int meetingCount = move(cowCount, positions, speeds, distance, time);
            totalMeetingCount+= meetingCount;

            barnWeight = calculateBarnWeight(cowCount, weights, positions, speeds, distance);
            loopCount++;
            System.out.println(loopCount);
        }

        output.print(totalMeetingCount);

        input.close();
        output.close();
    }

    static int move(int cowCount, double[] positions, int[] speeds, int distance, double time) {
        for (int i = 0; i < cowCount; i++) {
            positions[i] = positions[i] + time * speeds[i];
            if (floatEqual(positions[i], 0)) {
                speeds[i] = 0;
            }
            else if (floatEqual(positions[i], distance)) {
                speeds[i] = 0;
            }
        }

        int meetingCount = 0;
        for (int i = 0; i < cowCount; i++) {
            if (speeds[i] != 0) {
                if (i < cowCount -1 && speeds[i+1] != 0 && floatEqual(positions[i], positions[i +1])) {
                    meetingCount++;
                    int temp = speeds[i];
                    speeds[i] = speeds[i+1];
                    speeds[i+1] = temp;
                }
            }
        }

        return meetingCount;
    }

    static void sort(int cowCount, double[] positions, int[] speeds, int[] weights) {
        for (int i = 0; i < cowCount; i++) {
            int index = i;
            for (int j = i + 1; j < cowCount; j++) {
                if (positions[index] > positions[j]) {
                    index = j;
                }
            }
            double tempPosition = positions[i];
            positions[i] = positions[index];
            positions[index] = tempPosition;

            int temp = speeds[i];
            speeds[i] = speeds[index];
            speeds[index] = temp;

            temp = weights[i];
            weights[i] = weights[index];
            weights[index] = temp;
        }
    }


    static double nextMeetingTime(int cowCount, double[] positions, int[] speeds, int distance) {
        double ret = Double.MAX_VALUE;
        for (int i = 0; i < cowCount; i++) {
            if (speeds[i] == 0) {
                continue;
            }

            if (speeds[i] > 0) {
                // move right
                double time;
                if (i < cowCount -1 && speeds[i+1] < 0 ) {
                    time = (positions[i+1] - positions[i]) / 2;
                }
                else {
                    time = distance - positions[i];
                }
                ret = Math.min(ret, time);
            }
            else {
                // move left
                double time;
                if (i > 1 && speeds[i-1] > 0) {
                    time = (positions[i] - positions[i -1]) / 2;
                }
                else {
                    time = positions[i];
                }
                ret = Math.min(ret, time);    
            }
        }
        return ret;
    }

    static boolean floatEqual(double value, double toCompare) {
        if (Math.abs(value - toCompare) <= 0.000001) {
            return true;
        }

        return false;
    }

    static int calculateBarnWeight(int cowCount, int[] weights, double[] positions, int[] speeds, int distance) {
        int barnWeight = 0;
        for (int i = 0; i < cowCount; i++) {
            if (speeds[i] == 0) {
                barnWeight += weights[i];
            }
        }
        return barnWeight;
    }
}
