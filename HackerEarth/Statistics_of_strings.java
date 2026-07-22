import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    // Fast Modular Exponentiation
    private static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    // DSU find operation with path compression
    private static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long mod = Long.parseLong(st.nextToken());

        long totalSum = 0;
        int[] parent = new int[n];

        // Iterate over all possible lower bounds k for the Z-function
        for (int k = 1; k < n; ++k) {
            int maxPositions = n - k;
            int totalMasks = 1 << maxPositions;
            long countK = 0;

            // Iterate over all non-empty subsets of starting indices
            for (int mask = 1; mask < totalMasks; ++mask) {
                // Reset DSU array
                for (int i = 0; i < n; ++i) {
                    parent[i] = i;
                }

                int components = n;
                int setBits = 0;

                for (int bit = 0; bit < maxPositions; ++bit) {
                    if (((mask >> bit) & 1) == 1) {
                        setBits++;
                        int i = bit + 1; // Starting index offset (1-based)
                        for (int j = 0; j < k; ++j) {
                            int rootU = find(parent, j);
                            int rootV = find(parent, i + j);
                            if (rootU != rootV) {
                                parent[rootU] = rootV;
                                components--;
                            }
                        }
                    }
                }

                long ways = power(a, components, mod);

                // Apply Inclusion-Exclusion Principle
                if (setBits % 2 == 1) {
                    countK = (countK + ways) % mod;
                } else {
                    countK = (countK - ways + mod) % mod;
                }
            }

            totalSum = (totalSum + countK) % mod;
        }

        System.out.println(totalSum);
    }
}
