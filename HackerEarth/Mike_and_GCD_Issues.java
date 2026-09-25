import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TestClass {

    private static final int MAX_VAL = 200000;
    private static int[] spf = new int[MAX_VAL + 1];

    // Precompute Smallest Prime Factor (SPF) for fast prime factorization
    private static void buildSieve() {
        for (int i = 1; i <= MAX_VAL; i++) spf[i] = i;
        for (int i = 2; i * i <= MAX_VAL; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAX_VAL; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    // Get unique prime factors of x
    private static List<Integer> getPrimeFactors(int x) {
        List<Integer> factors = new ArrayList<>();
        while (x > 1) {
            int p = spf[x];
            factors.add(p);
            while (x % p == 0) {
                x /= p;
            }
        }
        return factors;
    }

    public static void main(String[] args) throws Exception {
        buildSieve();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        int[] a = new int[n + 1];

        List<List<Integer>> primeIndices = new ArrayList<>(MAX_VAL + 1);
        for (int i = 0; i <= MAX_VAL; i++) {
            primeIndices.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            a[i] = Integer.parseInt(st.nextToken());
            
            // Map index to its prime factors
            List<Integer> factors = getPrimeFactors(a[i]);
            for (int p : factors) {
                primeIndices.get(p).add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            List<Integer> factors = getPrimeFactors(a[i]);
            int bestJ = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int p : factors) {
                List<Integer> list = primeIndices.get(p);
                if (list.size() <= 1) continue; // No other index shares this prime factor

                int pos = Collections.binarySearch(list, i);

                // Check left neighbor
                if (pos - 1 >= 0) {
                    int cand = list.get(pos - 1);
                    int dist = Math.abs(i - cand);
                    if (dist < minDistance || (dist == minDistance && cand < bestJ)) {
                        minDistance = dist;
                        bestJ = cand;
                    }
                }

                // Check right neighbor
                if (pos + 1 < list.size()) {
                    int cand = list.get(pos + 1);
                    int dist = Math.abs(i - cand);
                    if (dist < minDistance || (dist == minDistance && cand < bestJ)) {
                        minDistance = dist;
                        bestJ = cand;
                    }
                }
            }

            sb.append(bestJ).append(i == n ? "" : " ");
        }

        System.out.println(sb.toString());
    }
}
