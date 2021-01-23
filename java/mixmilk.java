/*
TASK: mixmilk
LANG: JAVA
*/

import java.util.*;
import java.io.*;

public class mixmilk
{
	public static void main (String [] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new FileReader ("mixmilk.in"));
		
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("mixmilk.out")));
        
        int bucketCount = 3;
        int[] capacities = new int[bucketCount];
        int[] amounts = new int[bucketCount];

        for (int i = 0; i < bucketCount; i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            capacities[i] = Integer.parseInt(st.nextToken());
            amounts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 100; i++)
        {
            int fromBucket = i % bucketCount;
            int toBucket = (i + 1) % bucketCount;

            int toMove = 0;
            if (amounts[toBucket] + amounts[fromBucket] > capacities[toBucket])
            {
                toMove = capacities[toBucket] - amounts[toBucket];
            }
            else
            {
                toMove = amounts[fromBucket];
            }

            amounts[toBucket] += toMove;
            amounts[fromBucket] -= toMove;
        }

        for (int i = 0; i < bucketCount; i++)
        {
            out.println(amounts[i]);
        }

        out.close();
        in.close();
    }
}

