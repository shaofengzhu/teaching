import java.io.*;
import java.util.*;

enum Direction {
    N,
    E,
    S,
    W
}

public class stuckinrut {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        //input = new BufferedReader(new FileReader("stuckinrut.in"));
        input = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int[] cowXs = new int[cowCount];
        int[] cowYs = new int[cowCount];
        int[] cowStartXs = new int[cowCount];
        int[] cowStartYs = new int[cowCount];
        Direction[] cowDirections = new Direction[cowCount];
        boolean[] cowStopped = new boolean[cowCount];

        int[] cowCells = new int[cowCount];

        for (int i = 0; i < cowCount; i++) {
            st = new StringTokenizer(input.readLine());
            String strDirection = st.nextToken();
            cowDirections[i] = Direction.valueOf(strDirection);
            cowStartXs[i] = Integer.parseInt(st.nextToken());
            cowStartYs[i] = Integer.parseInt(st.nextToken());

            cowXs[i] = cowStartXs[i];
            cowYs[i] = cowStartYs[i];
            cowCells[i] = 1;
        }

        // int maxHour = Math.max(cowCount, 10000);
        for (int hour = 0; hour < cowCount; hour++) {

            int[] cowXsBeforeMove = Arrays.copyOf(cowXs, cowXs.length);
            int[] cowYsBeforeMove = Arrays.copyOf(cowYs, cowYs.length);

            int minIntersection = Integer.MAX_VALUE;
            for (int i = 0; i < cowCount; i++) {
                if (!cowStopped[i]) {
                    for (int j = 0; j < cowCount; j++) {
                        if (!cowStopped[j]) {
                            if (cowDirections[i] == Direction.N) {
                                if ((cowDirections[j] == Direction.E || cowDirections[j] == Direction.W) && cowYs[i] < cowYs[j]) {
                                    minIntersection = Math.min(minIntersection, cowYs[j] - cowYs[i]);
                                }
                            }
                            else if (cowDirections[i] == Direction.S) {
                                if ((cowDirections[j] == Direction.E || cowDirections[j] == Direction.W) && cowYs[i] > cowYs[j]) {
                                    minIntersection = Math.min(minIntersection, cowYs[i] - cowYs[j]);
                                }
                            }
                            else if (cowDirections[i] == Direction.W) {
                                if ((cowDirections[j] == Direction.N || cowDirections[j] == Direction.S) && cowXs[i] > cowXs[j]) {
                                    minIntersection = Math.min(minIntersection, cowXs[i] - cowXs[j]);
                                }
                            }
                            else {
                                // Move East
                                if ((cowDirections[j] == Direction.N || cowDirections[j] == Direction.S) && cowXs[i] < cowXs[j]) {
                                    minIntersection = Math.min(minIntersection, cowXs[j] - cowXs[i]);
                                }
                            }
                        }
                    }
                }
            }

            if (minIntersection == Integer.MAX_VALUE) {
                break;
            }
            
            for (int i = 0; i < cowCount; i++) {
                if (cowStopped[i]) {
                    continue;
                }

                if (cowDirections[i] == Direction.N) {
                    if (alreadyEatten(cowStartXs, cowStartYs, cowXsBeforeMove, cowYsBeforeMove, cowXs[i], cowYs[i] + minIntersection)) {
                        cowStopped[i] = true;
                        cowYs[i] = cowYs[i] + minIntersection - 1;
                        cowCells[i] += minIntersection - 1;
                    }
                    else {
                        cowYs[i] = cowYs[i] + minIntersection;
                        cowCells[i] += minIntersection;
                    }
                }
                else if (cowDirections[i] == Direction.E) {
                    if (alreadyEatten(cowStartXs, cowStartYs, cowXsBeforeMove, cowYsBeforeMove, cowXs[i] + minIntersection, cowYs[i])) {
                        cowStopped[i] = true;
                        cowXs[i] = cowXs[i] + minIntersection - 1;
                        cowCells[i] += minIntersection - 1;
                    }
                    else {
                        cowXs[i] = cowXs[i] + minIntersection;
                        cowCells[i] += minIntersection;
                    }
                }
                else if (cowDirections[i] == Direction.S) {
                    if (alreadyEatten(cowStartXs, cowStartYs, cowXsBeforeMove, cowYsBeforeMove, cowXs[i], cowYs[i] - minIntersection)) {
                        cowStopped[i] = true;
                        cowYs[i] = cowYs[i] - (minIntersection -1) ;
                        cowCells[i] += minIntersection - 1;
                    }
                    else {
                        cowYs[i] = cowYs[i] - minIntersection;
                        cowCells[i] += minIntersection;
                    }
                }
                else {
                    // Direction.W
                    if (alreadyEatten(cowStartXs, cowStartYs, cowXsBeforeMove, cowYsBeforeMove, cowXs[i] -minIntersection, cowYs[i])) {
                        cowStopped[i] = true;
                        cowXs[i] = cowXs[i] - (minIntersection -1);
                        cowCells[i] += minIntersection - 1;
                    }
                    else {
                        cowXs[i] = cowXs[i] - minIntersection;
                        cowCells[i] += minIntersection;
                    }
                }
            }

            boolean allStopped = true;
            for (int i = 0; i < cowCount; i++) {
                if (!cowStopped[i]) {
                    allStopped = false;
                    break;
                }
            }

            if (allStopped) {
                break;
            }
        }

        for (int i = 0; i < cowCount; i++) {
            if (!cowStopped[i]) {
                System.out.println("Infinity");
            }
            else {
                System.out.println(cowCells[i]);
            }
        }

        input.close();
    }

    static boolean alreadyEatten(int[] cowStartXs, int[] cowStartYs, int[] cowXs, int[] cowYs, int x, int y) {
        for (int i = 0; i < cowStartXs.length; i++) {
            if (between(cowStartXs[i], cowXs[i], x) && between(cowStartYs[i], cowYs[i], y)) {
                return true;
            }
        }
        return false;
    }

    static boolean between(int a, int b, int value) {
        return value >= Math.min(a, b) && value <= Math.max(a, b);
    }
}
