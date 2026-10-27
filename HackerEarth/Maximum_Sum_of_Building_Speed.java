import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        int totalWorkers = 2 * n;
        long[] speeds = new long[totalWorkers];

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < totalWorkers; i++) {
            speeds[i] = Long.parseLong(st.nextToken());
        }

        // Sort the speeds in ascending order
        Arrays.sort(speeds);

        long maxSum = 0;
        // Pair adjacent workers (0 and 1, 2 and 3, etc.)
        for (int i = 0; i < totalWorkers; i += 2) {
            maxSum += speeds[i];
        }

        System.out.println(maxSum);
    }
}
