import java.io.*;
import java.util.*;


public class reststops2
{
    public static void main (String[] args) throws IOException 
    {
        BufferedReader in = new BufferedReader(new FileReader("reststops.in"));
        PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
        StringTokenizer line = new StringTokenizer(in.readLine());

        long length = Long.parseLong(line.nextToken());
        long howManyStops = Long.parseLong(line.nextToken());
        long farmerRate = Long.parseLong(line.nextToken());
        long bessieRate = Long.parseLong(line.nextToken());

        long deltaRate = farmerRate-bessieRate;

        ArrayList<Long> whereStops = new ArrayList<Long>();
        ArrayList<Long> howTasty = new ArrayList<Long>();

        // for (int i = 0; i<whereStops.size()-1; i++)
        // {
        //     if (whereStops.get(i)>whereStops.get(i+1))
        //     {
        //         int temp = whereStops.get(i);
        //         whereStops.set(i, whereStops.get(i+1));
        //         whereStops.set(i+1,temp);

        //         int temp2 = howTasty.get(i);
        //         howTasty.set(i, howTasty.get(i+1));
        //         howTasty.set(i+1,temp);
        //     }
        // }

        for (int i = 0; i<howManyStops; i++)
        {
            StringTokenizer line2 = new StringTokenizer(in.readLine());
            whereStops.add(Long.parseLong(line2.nextToken()));
            howTasty.add(Long.parseLong(line2.nextToken()));
        }

        //simplify the array 
        for (int i = howTasty.size()-2; i>=0; i--)
        {
            if (howTasty.get(i)<=howTasty.get(i+1))
            {
                howTasty.remove(i);
                whereStops.remove(i);
            }
        }

        for (int i = 0; i < howTasty.size(); i++) {
            System.out.println("Stop:" + whereStops.get(i));
        }

        long[]distances = new long[whereStops.size()];
        distances[0]=whereStops.get(0);
        for (int i = 1; i<whereStops.size(); i++)
        {
            distances[i]=whereStops.get(i)-whereStops.get(i-1);
        }

        long tastyCount = 0;

        for (int i = 0; i<whereStops.size(); i++)
        {
            long howManyGrassPoints = reststops2.getGrassPoints(howTasty, distances, i, deltaRate);
            System.out.println(howManyGrassPoints);
            tastyCount += howManyGrassPoints;
        }

        out.println(tastyCount);

        in.close();
        out.close();
    }

    public static long getGrassPoints (ArrayList<Long>howTasty, long [] distances, int stopIndex, long deltaRate)
    {
        return distances[stopIndex]*deltaRate*howTasty.get(stopIndex);
    }

    
}