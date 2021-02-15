import java.io.*;
import java.util.*;

public class snowboots {

    private static int g_minBootIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("snowboots.in"));
        PrintWriter output = new PrintWriter(new FileWriter("snowboots.out"));

        StringTokenizer st = new StringTokenizer(input.readLine());

        int tileCount = Integer.parseInt(st.nextToken());
        int bootCount = Integer.parseInt(st.nextToken());

        g_minBootIndex = bootCount;

        int[] tileSnowDepths = new int[tileCount];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < tileCount; i++) {
            // read the tile's snow depth
            tileSnowDepths[i] = Integer.parseInt(st.nextToken());
        }

        int[] bootDepths = new int[bootCount];
        int[] bootMaxSteps = new int[bootCount];
        for (int i = 0; i < bootCount; i++) {
            st = new StringTokenizer(input.readLine());
            int bootDepth = Integer.parseInt(st.nextToken());
            int bootMaxStep = Integer.parseInt(st.nextToken());
            // read the boot's depth and boot max step
            bootDepths[i] = bootDepth;
            bootMaxSteps[i] = bootMaxStep;
        }

        // Initialize the visitedBootTile array.
        boolean[][] visitedBootTile = new boolean[bootCount][];
        for (int i = 0; i < bootCount; i++) {
            visitedBootTile[i] = new boolean[tileCount];
        }

        // Now, we are going to start with boot 0 and tile 0
        visit(visitedBootTile, bootDepths, bootMaxSteps, tileSnowDepths, 0, 0);

        // Now, the g_minBootIndex should be the minimal boot index that could reach to the last tile
        // The minimal number of boots that are discarded is just the minimal boot index. 
        output.println(g_minBootIndex);

        input.close();
        output.close();
    }

    static void visit(boolean[][] visitedBootTile, int[] bootDepths, int[] bootMaxSteps, int[] tileSnowDepths, int bootIndex, int tileIndex) {
        // If we have already checked (boot,tile), we do not need to check it again.
        if (visitedBootTile[bootIndex][tileIndex]) {
            return;
        }

        // mark the (boot, tile) as visited
        visitedBootTile[bootIndex][tileIndex] = true;

        // Check whether we have reached the last tile.
        if (tileIndex == tileSnowDepths.length -1) {
            // we have reached the last tile with the bootIndex.
            // It means that we could reach to the last tile with the bootIndex.
            // As we need to find the minimal boot to be discarded, we will store the minimal value.
            g_minBootIndex = Math.min(bootIndex, g_minBootIndex);
            return;
        }

        // Use the boot to step 1 to bootMaxSteps[bootIndex] steps
        for (int i = tileIndex + 1; i < tileSnowDepths.length && i - tileIndex <= bootMaxSteps[bootIndex]; i++) {
            if (tileSnowDepths[i] <= bootDepths[bootIndex]) {
                // if the boot's depth is large than the tile's snow depth, the boot could stay that tile
                // we could visit the tile.
                visit(visitedBootTile, bootDepths, bootMaxSteps, tileSnowDepths, bootIndex, i);
            }
        }

        // Or, we could change to all other boots
        for (int i = bootIndex + 1; i < bootMaxSteps.length; i++) {
            if (tileSnowDepths[tileIndex] < bootDepths[i]) {
                // The new boot's depth is large than the tile's snow depth
                // we could use the new boot on the tile and start to visit all of the tiles.
                visit(visitedBootTile, bootDepths, bootMaxSteps, tileSnowDepths, i, tileIndex);
            }
        }
    }
}
