import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            st = new StringTokenizer(line);
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Difference array to manage 2D flipping updates efficiently
        int[][] diff = new int[n + 2][m + 2];
        long flipsNeeded = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Compute accumulated flips using prefix sums over diff array
                diff[i + 1][j + 1] ^= diff[i][j + 1] ^ diff[i + 1][j] ^ diff[i][j];

                // Current state: 0 (hole) needs a flip if active flip count is even
                int currentVal = grid[i][j] ^ diff[i + 1][j + 1];

                if (currentVal == 0) {
                    // If a flip is needed but the k x k window goes out of bounds, impossible
                    if (i + k > n || j + k > m) {
                        System.out.println(-1);
                        return;
                    }

                    flipsNeeded++;

                    // Apply a 2D range XOR update for the k x k region starting at (i, j)
                    diff[i + 1][j + 1] ^= 1;
                    diff[i + 1][j + k + 1] ^= 1;
                    diff[i + k + 1][j + 1] ^= 1;
                    diff[i + k + 1][j + k + 1] ^= 1;
                }
            }
        }

        System.out.println(flipsNeeded);
    }
}
