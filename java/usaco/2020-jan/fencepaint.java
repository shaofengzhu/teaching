import java.io.*;
import java.util.*;

public class fencepaint {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        input = new BufferedReader(new FileReader("fencepaint.in"));
        //input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int segmentCount = Integer.parseInt(st.nextToken());
        int caseCount = Integer.parseInt(st.nextToken());
        String desiredColors = input.readLine();
        for (int i =0; i < caseCount; i++) {
            st = new StringTokenizer(input.readLine());

            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            String first = desiredColors.substring(0, startIndex -1);
            String second = desiredColors.substring(endIndex);

            int strokesFirst = calculateStrokes(first);
            int strokesSecond = calculateStrokes(second);
            System.out.println(strokesFirst + strokesSecond);
        }

        input.close();
    }

    static int calculateStrokes(String colors) {
        if (colors.length() == 0) {
            return 0;
        }
        else if (colors.length() == 1) {
            return 1;
        }

        char[] colorChars = colors.toCharArray();

        int count = 0;

        return count;
    }
}
