import java.io.*;
import java.util.*;

public class breedid {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        //input = new BufferedReader(new FileReader("breedid.in"));
        input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] cowIds = new int[cowCount];
        for (int i = 0; i < cowCount; i++) {
            cowIds[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < cowCount; i++) {
            if (cowIds[i] %2 == 0) {
                evenList.add(cowIds[i]);
            }
            else {
                oddList.add(cowIds[i]);
            }
        }

        int count = 0;
        while(evenList.size() + oddList.size() > 0) {
            boolean canFormNewGroup = tryRemoveToFormNewGroup(evenList, oddList, count % 2 == 0);
            if (canFormNewGroup) {
                count++;
            }
            else {
                break;
            }
        }

        count -= oddList.size();

        System.out.println(count);

        input.close();
    }

    static boolean tryRemoveToFormNewGroup(ArrayList<Integer> evenList, ArrayList<Integer> oddList, boolean even) {
        if (even) {
            if (evenList.size() > 0) {
                evenList.remove(0);
                return true;
            }

            if (oddList.size() > 1) {
                oddList.remove(1);
                oddList.remove(0);
                return true;
            }

            return false;
        }
        else {
            if (oddList.size() > 0) {
                oddList.remove(0);
                return true;
            }

            return false;
        }
    }

    static int findItem(ArrayList<Integer> list, int startIndex, boolean even) {
        for (int i = startIndex; i < list.size(); i++) {
            if (even && list.get(i) % 2 == 0) {
                return i;
            }
            if (!even && list.get(i) %2 == 1) {
                return i;
            }
        }

        return -1;
    }
}
