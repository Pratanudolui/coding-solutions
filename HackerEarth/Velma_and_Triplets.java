import java.io.*;
import java.util.*;

public class Main {

    static long C(long n, long r) {
        if (r > n) {
            return 0;
        }

        if (r > n - r) {
            r = n - r;
        }

        long res = 1;

        for (long i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        long[] freq = new long[50005];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            freq[x]++;
        }

        long res = 0;

        if (freq[1] > 0) {
            res += 3 * C(freq[1], 3);
            res += freq[1] * C(freq[2], 2);
            res += 2 * freq[2] * C(freq[1], 2);
            res += freq[1] * freq[2] * freq[3];

            for (int i = 3; i <= 50000; i++) {
                res += freq[i] * C(freq[1], 2);
            }

            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }
}
