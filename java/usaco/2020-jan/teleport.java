import java.io.*;
import java.util.*;

public class teleport {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter output = new PrintWriter(new FileWriter("teleport.out"));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int count = Integer.parseInt(st.nextToken());

        long[] A = new long[count];
        long[] B = new long[count];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(input.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Long> points = new ArrayList<Long>();

        for (int i = 0; i < count; i++) {
            if (Math.abs(A[i] - B[i]) < Math.abs(A[i])) {
                // it does not need to use teleport
                continue;
            }

            if (!points.contains(2*A[i])) {
                points.add(2*A[i]);
            }

            if (!points.contains(2*B[i])) {
                points.add(2*B[i]);
            }
            if (!points.contains(A[i])) {
                points.add(A[i]);
            }
            if (!points.contains(B[i])) {
                points.add(B[i]);
            }
            if (!points.contains(2*(B[i] - A[i]))) {
                points.add(2*(B[i] - A[i]));
            }
            
            if (!points.contains(2*(A[i] - B[i]))) {
                points.add(2*(A[i] - B[i]));
            }
        }

        long position = points.get(0);
        long minTotalDistance = calculateTotalDistance(A, B, position);
        for (int i = 0; i < points.size(); i++) {
            long y = points.get(i);
            long totalDistance = calculateTotalDistance(A, B, y);
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
                position = y;
            }
        }

        //System.out.println(position);
        //System.out.println(minTotalDistance);

        output.println(minTotalDistance);

        input.close();
        output.close();
    }

    static long calculateTotalDistance(long[] A, long[] B, long y) {
        long total = 0;
        for (int i = 0; i < A.length; i++) {
            long d = Math.abs(A[i] - B[i]);
            long d2 = Math.abs(A[i]) + Math.abs(B[i] - y);
            total += Math.min(d, d2);
        }

        return total;
    }
}