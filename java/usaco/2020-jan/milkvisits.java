import java.io.*;
import java.util.*;

class Farm {
    public char milk;
    public ArrayList<Integer> connectedFarms;
    int componentId;
}

public class milkvisits {

    private static int g_nextComponentId;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter output = new PrintWriter(new FileWriter("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int farmCount = Integer.parseInt(st.nextToken());
        int friendCount = Integer.parseInt(st.nextToken());

        String milks = input.readLine().trim();

        Farm[] farms = new Farm[farmCount];
        for (int i = 0; i < farmCount; i++) {
            farms[i] = new Farm();
            farms[i].connectedFarms = new ArrayList<Integer>();
            farms[i].milk = milks.charAt(i);
        }

        for (int i = 0; i < farmCount -1; i++) {
            st = new StringTokenizer(input.readLine());
            int indexOfFarmA = Integer.parseInt(st.nextToken()) - 1;
            int indexOfFarmB = Integer.parseInt(st.nextToken()) - 1;
            
            // FarmA connecto to FarmB
            farms[indexOfFarmA].connectedFarms.add(indexOfFarmB);
            // BarmB connect to FarmA
            farms[indexOfFarmB].connectedFarms.add(indexOfFarmA);
        }

        g_nextComponentId = 1;

        // As all of the farms are connected, we will start with the first farm.
        // We will use the first farm's milk as the component milk

        // We should get the same answer even if we start with other farm as all 
        // of the farms are connected.

        setComponentIdUsingDepthFirstSearch(farms, 0, farms[0].milk, ++g_nextComponentId);

        for (int i = 0; i < friendCount; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            char milk = st.nextToken().charAt(0);

            boolean isSatisfied = calculateSatisified(farms, a, b, milk);
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

    static void setComponentIdUsingDepthFirstSearch(Farm[] farms, int currentFarmIndex, char componentMilk, int componentId) {
        if (farms[currentFarmIndex].componentId != 0) {
            // We have already visited it and we do not need to proceed.
            return;
        }

        // The farm's component id is not set
        if (farms[currentFarmIndex].milk == componentMilk) {
            // the milk is same, use the same componentId
            farms[currentFarmIndex].componentId = componentId;
        }
        else
        {
            // The milk is not same, use the next component id.
            farms[currentFarmIndex].componentId = ++g_nextComponentId;
        }

        // loop through it's connected farms
        for (int i = 0; i < farms[currentFarmIndex].connectedFarms.size(); i++) {
            int nextFarm = farms[currentFarmIndex].connectedFarms.get(i);
            // recursively work on the nextFarm and check whether the next farm 
            // should belongs to the same component as current farm.
            // So we use the current farm's milk as the component milk            
            setComponentIdUsingDepthFirstSearch(farms, nextFarm, farms[currentFarmIndex].milk, farms[currentFarmIndex].componentId);
        }
    }


    static boolean calculateSatisified(Farm[] farms, int start, int end, char milk) {
        if (farms[start].milk == milk) {
            return true;
        }

        if (farms[end].milk == milk) {
            return true;
        }

        if (farms[start].componentId != farms[end].componentId) {
            return true;
        }

        return false;
    }
}