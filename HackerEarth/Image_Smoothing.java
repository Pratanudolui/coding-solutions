import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int filterSize = 2 * m + 1;
        long[][] f = new long[filterSize][filterSize];

        for (int i = 0; i < filterSize; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < filterSize; j++) {
                f[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] g = new long[n][n];
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
                g[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] newG = new long[n][n];

        // Apply smoothing operation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int p = -m; p <= m; p++) {
                    for (int q = -m; q <= m; q++) {
                        int ni = i + p;
                        int nj = j + q;
                        // If situated outside of grid of size N x N, value is 0
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            long pixelVal = g[ni][nj];
                            long filterVal = f[p + m][q + m];
                            sum += pixelVal * filterVal;
                        }
                    }
                }
                newG[i][j] = sum;
            }
        }

        // Print output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(newG[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
