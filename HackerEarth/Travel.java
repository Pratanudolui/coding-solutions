import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // minPos and maxPos for each magic number from 1 to K
            int[] minPos = new int[k + 1];
            int[] maxPos = new int[k + 1];
            Arrays.fill(minPos, Integer.MAX_VALUE);
            Arrays.fill(maxPos, -1);

            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;

            st = new StringTokenizer(line);
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                if (val <= k) {
                    if (i < minPos[val]) minPos[val] = i;
                    if (i > maxPos[val]) maxPos[val] = i;
                }
            }

            // If k == 1, distance traveled is 0 since there's only 1 city to visit
            if (k == 1) {
                sb.append(0).append("\n");
                continue;
            }

            // dpMin[v] = max distance to reach minPos[v]
            // dpMax[v] = max distance to reach maxPos[v]
            long[] dpMin = new long[k + 1];
            long[] dpMax = new long[k + 1];

            for (int v = 2; v <= k; v++) {
                // From v-1 to v, we can transition from minPos[v-1] or maxPos[v-1]
                long fromMinPrev = dpMin[v - 1] + Math.abs(minPos[v] - minPos[v - 1]);
                long fromMaxPrev = dpMax[v - 1] + Math.abs(minPos[v] - maxPos[v - 1]);
                dpMin[v] = Math.max(fromMinPrev, fromMaxPrev);

                fromMinPrev = dpMin[v - 1] + Math.abs(maxPos[v] - minPos[v - 1]);
                fromMaxPrev = dpMax[v - 1] + Math.abs(maxPos[v] - maxPos[v - 1]);
                dpMax[v] = Math.max(fromMinPrev, fromMaxPrev);
            }

            // The answer is the maximum distance achieved at the final magic number K
            long maxDistance = Math.max(dpMin[k], dpMax[k]);
            sb.append(maxDistance).append("\n");
        }
        System.out.print(sb);
    }
}
