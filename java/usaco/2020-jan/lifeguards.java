import java.io.*;
import java.util.*;

class Shift {
    public long start;
    public long end;
}

class TimeSegment {
    public long time;
    public int lifeGuardIndex;
}

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter output = new PrintWriter(new FileWriter("lifeguards.out"));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int count = Integer.parseInt(st.nextToken());

        Shift[] shifts = new Shift[count];
        for (int i = 0; i < count; i++) {
            shifts[i] = new Shift();
            st = new StringTokenizer(input.readLine());
            shifts[i].start = Long.parseLong(st.nextToken());
            shifts[i].end = Long.parseLong(st.nextToken());
        }

        TimeSegment[] segments = new TimeSegment[count * 2];

        for (int i = 0; i < count; i++) {
            TimeSegment segment = new TimeSegment();
            segment.time = shifts[i].start;
            segment.lifeGuardIndex = i;
            segments[i * 2 ] = segment;

            segment = new TimeSegment();
            segment.time = shifts[i].end;
            segment.lifeGuardIndex = i;
            segments[i * 2 + 1] = segment;
        }

        Arrays.sort(segments, (a, b) -> {
            return (int) (a.time - b.time);
        });

        // you could also use ArrayList<Integer>
        // We use TreeSet<Integer> just for efficient
        ArrayList<Integer> workingLifeGuards = new ArrayList<Integer>();
        long last = 0;
        long actualCover = 0;
        long[] alone = new long[count];
        for (int i = 0; i < segments.length; i++) {
            if (workingLifeGuards.size() == 1) {
                // there is only one life guard working
                int lifeGuardIndex = workingLifeGuards.get(0);
                alone[lifeGuardIndex] += segments[i].time - last;
            }

            if (!workingLifeGuards.isEmpty()) {
                // there is one or more life guards. It's part of the total covered time.
                actualCover += segments[i].time - last;
            }

            // Now check whether the lifeguard in in the list
            int index = workingLifeGuards.indexOf(segments[i].lifeGuardIndex);

            if (index >= 0) {
                // it's the end time for the life guard
                workingLifeGuards.remove(index);
            }
            else {
                // it's the start time of the life guard
                // add the life guard to the workingLifeGuards
                workingLifeGuards.add(segments[i].lifeGuardIndex);
            }

            last = segments[i].time;
        }

        long result = 0;
        for (int i = 0; i < count; i++) {
            result = Math.max(result, actualCover - alone[i]);
        }


        output.println(result);

        input.close();
        output.close();
    }
}
