import java.io.*;
import java.util.*;

class Farm0 {
    public char milk;
    public ArrayList<Integer> connectedFarms;
}

public class milkvisits0 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter output = new PrintWriter(new FileWriter("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int farmCount = Integer.parseInt(st.nextToken());
        int friendCount = Integer.parseInt(st.nextToken());

        String milks = input.readLine().trim();

        Farm0[] farms = new Farm0[farmCount];
        for (int i = 0; i < farmCount; i++) {
            // initialize the ith farm
            farms[i] = new Farm0();
            farms[i].connectedFarms = new ArrayList<Integer>();
            farms[i].milk = milks.charAt(i);
        }

        for (int i = 0; i < farmCount -1; i++) {
            st = new StringTokenizer(input.readLine());
            int indexA = Integer.parseInt(st.nextToken()) - 1;
            int indexB = Integer.parseInt(st.nextToken()) - 1;

            // Add B to farm A's connected farms 
            farms[indexA].connectedFarms.add(indexB);
            // Add A to farm B's connected farms
            farms[indexB].connectedFarms.add(indexA);
        }

        for (int i = 0; i < friendCount; i++) {
            st = new StringTokenizer(input.readLine());
            int indexA = Integer.parseInt(st.nextToken()) - 1;
            int indexB = Integer.parseInt(st.nextToken()) - 1;
            char milk = st.nextToken().charAt(0);

            boolean isSatisfied = calculateSatisified(farms, indexA, indexB, milk);
            if (isSatisfied) {
                output.print(1);
            }
            else {
                output.print(0);
            }
        }

        output.println();

        input.close();
        output.close();
    }


    static boolean calculateSatisified(Farm0[] farms, int start, int end, char milk) {
        // quickly check the endpoints
        if (farms[start].milk == milk) {
            return true;
        }

        if (farms[end].milk == milk) {
            return true;
        }

        // now we need to find the path from start to end.
        // we use the currentPath to indicate the path from start to the current farm.
        // if the current farm is the end, we find it and we will copy the path to the resultPath.
        ArrayList<Integer> currentPath = new ArrayList<Integer>();
        ArrayList<Integer> resultPath = new ArrayList<Integer>();

        // Initialize the currentPath with "start"
        currentPath.add(start);

        deepthFirstSearch(farms, start, end, currentPath, resultPath);

        // now check all of the farms on the resultPath
        for (int i = 0; i < resultPath.size(); i++) {
            if (farms[resultPath.get(i)].milk == milk) {
                // if any of the farm on the resultPath has the expected milk
                return true;
            }
        }

        return false;
    }

    static void deepthFirstSearch(Farm0[] farms, int start, int end, ArrayList<Integer> path, ArrayList<Integer> resultPath) {
        if (start == end) {
            path.add(end);
            
            // We find it. We will copy the path to the resultPath.
            for (int i = 0; i < path.size(); i++) {
                resultPath.add(path.get(i));
            }
            return;
        }

        // We will check all of the connectedFarms of the start.
        for (int i = 0; i < farms[start].connectedFarms.size(); i++) {

            int nextFarm = farms[start].connectedFarms.get(i);

            // if the nextFarm is not already on the path
            if (!path.contains(nextFarm)) {
                int index = path.size();

                // We will add the nextFarm to the path
                path.add(nextFarm);

                // now search the connectedFarms of the nextFarm
                deepthFirstSearch(farms, nextFarm, end, path, resultPath);

                // remove the nextFarm from the path
                path.remove(index);
            }
        }
    }
}