/*
TASK: backforth
LANG: JAVA
*/

import java.util.*;
import java.io.*;

public class backforth
{
	public static void main (String [] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new FileReader ("backforth.in"));
        PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("backforth.out")));
        
        ArrayList<Integer> mondayFirstBarnBuckets = new ArrayList<Integer>();
        ArrayList<Integer> mondaySecondBarnBuckets = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++) {
            mondayFirstBarnBuckets.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 10; i++) {
            mondaySecondBarnBuckets.add(Integer.parseInt(st.nextToken()));
        }

        int mondayFirstBarnTank = 1000;
        int mondaySecondBarnTank = 1000;

        ArrayList<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < mondayFirstBarnBuckets.size(); i++) {
            // Tuesday: move from 1 to 2
            ArrayList<Integer> tuesdayFirstBarnBuckets = new ArrayList<Integer>(mondayFirstBarnBuckets);
            tuesdayFirstBarnBuckets.remove(i);
            int tuesdayFirstBarnTank = mondayFirstBarnTank - mondayFirstBarnBuckets.get(i);
            ArrayList<Integer> tuesdaySecondBarnBuckets = new ArrayList<Integer>(mondaySecondBarnBuckets);
            tuesdaySecondBarnBuckets.add(mondayFirstBarnBuckets.get(i));
            int tuesdaySecondBarnTank = mondaySecondBarnTank + mondayFirstBarnBuckets.get(i);

            for (int j = 0; j < tuesdaySecondBarnBuckets.size(); j++) {
                // Wednesday: move from 2 to 1
                ArrayList<Integer> wednesdayFirstBarnBuckets = new ArrayList<Integer>(tuesdayFirstBarnBuckets);
                ArrayList<Integer> wednesdaySecondBarnBuckets = new ArrayList<Integer>(tuesdaySecondBarnBuckets);
                wednesdaySecondBarnBuckets.remove(j);
                wednesdayFirstBarnBuckets.add(tuesdaySecondBarnBuckets.get(j));
                int wednesdayFirstBarnTank = tuesdayFirstBarnTank + tuesdaySecondBarnBuckets.get(j);
                int wednesdaySecondBarnTank = tuesdaySecondBarnTank - tuesdaySecondBarnBuckets.get(j);

                for (int k = 0; k < wednesdayFirstBarnBuckets.size(); k++) {
                    // Thursday: move from 1 to 2
                    ArrayList<Integer> thursdayFirstBarnBuckets = new ArrayList<Integer>(wednesdayFirstBarnBuckets);
                    thursdayFirstBarnBuckets.remove(k);
                    int thursdayFirstBarnTank = wednesdayFirstBarnTank - wednesdayFirstBarnBuckets.get(k);
                    ArrayList<Integer> thursdaySecondBarnBuckets = new ArrayList<Integer>(wednesdaySecondBarnBuckets);
                    thursdaySecondBarnBuckets.add(wednesdayFirstBarnBuckets.get(k));
                    int thursdaySecondBarnTank = wednesdaySecondBarnTank + wednesdayFirstBarnBuckets.get(k);

                    for (int m = 0; m < thursdaySecondBarnBuckets.size(); m++) {
                        // Friday: move from 2 to 1
                        ArrayList<Integer> fridayFirstBarnBuckets = new ArrayList<Integer>(thursdayFirstBarnBuckets);
                        ArrayList<Integer> fridaySecondBarnBuckets = new ArrayList<Integer>(thursdaySecondBarnBuckets);
                        fridaySecondBarnBuckets.remove(m);
                        fridayFirstBarnBuckets.add(thursdaySecondBarnBuckets.get(m));
                        int fridayFirstBarnTank = thursdayFirstBarnTank + thursdaySecondBarnBuckets.get(m);
                        int fridaySecondBarnTank = thursdaySecondBarnTank - thursdaySecondBarnBuckets.get(m);
                        if (!results.contains(fridayFirstBarnTank)) {
                            results.add(fridayFirstBarnTank);
                        }
                    }
                
                }
            }

        }

        out.println(results.size());

        in.close();
        out.close();
    }
}