/*
TASK: blist
LANG: JAVA
*/

import java.util.*;
import java.io.*;

public class blist
{
	public static void main (String [] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new FileReader ("blist.in"));
		
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("blist.out")));
		
        StringTokenizer firstLine = new StringTokenizer(in.readLine());
        
        int count = Integer.parseInt((firstLine.nextToken()));
        int[] startTime = new int[count];
        int[] endTime = new int[count];
        int[] bucketNeeded = new int[count];

        for (int i = 0; i < count; i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            startTime[i] = Integer.parseInt(st.nextToken());
            endTime[i] = Integer.parseInt(st.nextToken());
            bucketNeeded[i] = Integer.parseInt(st.nextToken());
        }

        // first find the max time
        int maxTime = 0;
        for (int i = 0; i < count; i++) {
            if (maxTime < endTime[i]) {
                maxTime = endTime[i];
            }
        }

        int bucketNeededTotal[] = new int[maxTime + 1];
        for (int i = 0; i < count; i++)
        {
            for (int t = startTime[i]; t <= endTime[i]; t++)
            {
                bucketNeededTotal[t] += bucketNeeded[i];
            }
        }

        int maxBucketNeeded = 0;
        for (int i = 0; i < bucketNeededTotal.length; i++)
        {
            if (maxBucketNeeded < bucketNeededTotal[i]) {
                maxBucketNeeded = bucketNeededTotal[i];
            }
        }
        
        out.println((maxBucketNeeded));
        out.close();
        in.close();
    }
}
