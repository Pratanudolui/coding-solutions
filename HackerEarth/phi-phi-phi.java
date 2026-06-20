import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static final Random rnd = new Random();

    static long mulMod(long a, long b, long mod) {
        return BigInteger.valueOf(a)
                .multiply(BigInteger.valueOf(b))
                .mod(BigInteger.valueOf(mod))
                .longValue();
    }

    static long powMod(long a, long d, long mod) {
        long res = 1;
        while (d > 0) {
            if ((d & 1) == 1) res = mulMod(res, a, mod);
            a = mulMod(a, a, mod);
            d >>= 1;
        }
        return res;
    }

    static boolean isPrime(long n) {
        if (n < 2) return false;

        int[] smallPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (int p : smallPrimes) {
            if (n % p == 0) return n == p;
        }

        long d = n - 1;
        int s = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            s++;
        }

        long[] bases = {2, 3, 5, 7, 11, 13, 17};

        for (long a : bases) {
            if (a >= n) continue;

            long x = powMod(a, d, n);

            if (x == 1 || x == n - 1) continue;

            boolean witness = true;

            for (int r = 1; r < s; r++) {
                x = mulMod(x, x, n);
                if (x == n - 1) {
                    witness = false;
                    break;
                }
            }

            if (witness) return false;
        }

        return true;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    static long pollardRho(long n) {
        if ((n & 1) == 0) return 2;

        while (true) {
            long c = Math.abs(rnd.nextLong()) % (n - 1) + 1;
            long x = Math.abs(rnd.nextLong()) % (n - 2) + 2;
            long y = x;
            long d = 1;

            while (d == 1) {
                x = (mulMod(x, x, n) + c) % n;
                y = (mulMod(y, y, n) + c) % n;
                y = (mulMod(y, y, n) + c) % n;

                d = gcd(Math.abs(x - y), n);
            }

            if (d != n) return d;
        }
    }

    static void factor(long n, Map<Long, Integer> map) {
        if (n == 1) return;

        if (isPrime(n)) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            return;
        }

        long d = pollardRho(n);

        factor(d, map);
        factor(n / d, map);
    }

    static long phi(long n) {
        if (n == 1) return 1;

        Map<Long, Integer> factors = new HashMap<>();
        factor(n, factors);

        long result = n;

        for (long p : factors.keySet()) {
            result = result / p * (p - 1);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        while (k > 0 && n > 1) {
            n = phi(n);
            k--;
        }

        System.out.println(n);
    }
}
