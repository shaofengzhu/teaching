import java.io.*;
import java.util.*;

class IndexAndPosition {
    public int index;
    public int position;

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        IndexAndPosition other = (IndexAndPosition)o;
        return other.index == index && other.position == position;
    }
}

public class dancemove {
    public static void main(String[] args) throws IOException {
        BufferedReader input;
        //input = new BufferedReader(new FileReader("dancemove.in"));
        input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int swapCount = Integer.parseInt(st.nextToken());
        int[] swapA = new int[swapCount];
        int[] swapB = new int[swapCount];
        for (int i = 0; i < swapCount; i++) {
            st = new StringTokenizer(input.readLine());
            swapA[i] = Integer.parseInt(st.nextToken()) -1;
            swapB[i] = Integer.parseInt(st.nextToken()) -1;
        }

        for (int i = 0; i < cowCount; i++) {
            int start = -1;
            for (int j = 0; j < swapA.length; j++) {
                if (swapA[j] == i || swapB[j] == i) {
                    start = j;
                    break;
                }
            }

            if (start < 0) {
                System.out.println(1);
            }
            else {
                int currentPosition = i;
                IndexAndPosition next = new IndexAndPosition();
                next.index = start;
                next.position = i;
                ArrayList<Integer> uniquePositions = new ArrayList<Integer>();
                HashSet<IndexAndPosition> uniqueIndexAndPosition = new HashSet<IndexAndPosition>();
                uniquePositions.add(currentPosition);

                //start;
                for (int j = 0; j < swapA.length * cowCount; j++) {
                    next = getNextPosition(swapA, swapB, start, currentPosition);
                    if (next != null) {
                        if (!uniquePositions.contains(next.position)) {
                            uniquePositions.add(next.position);
                        }

                        if (uniqueIndexAndPosition.contains(next)) {
                            break;
                        }
                        else {
                            uniqueIndexAndPosition.add(next);
                        }

                        start = next.index;
                        currentPosition = next.position;
                        start++;
                    }
                    else {
                        break;
                    }
                }

                System.out.println(uniquePositions.size());
            }
        }

        input.close();
    }

    static IndexAndPosition getNextPosition(int[] swapA, int[] swapB, int start, int currentPossition) {
        for (int i = 0; i < swapA.length; i++) {
            int index = (start+i) % swapA.length;
            if (swapA[index] == currentPossition) {
                IndexAndPosition ret = new IndexAndPosition();
                ret.index = index;
                ret.position = swapB[index];
                return ret;
            }
            if (swapB[index] == currentPossition) {
                IndexAndPosition ret = new IndexAndPosition();
                ret.index = index;
                ret.position = swapA[index];
                return ret;
            }
        }

        return null;
    }
}

