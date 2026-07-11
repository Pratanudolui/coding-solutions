import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000007L;
    static ArrayList<Long> divisors = new ArrayList<>();
    static ArrayList<Long> primes = new ArrayList<>();
    static ArrayList<Integer> powers = new ArrayList<>();

    static void gen(int idx, long cur) {
        if (idx == primes.size()) {
            divisors.add(cur);
            return;
        }
        long val = 1;
        for (int i = 0; i <= powers.get(idx); i++) {
            gen(idx + 1, cur * val);
            val *= primes.get(idx);
        }
    }

    static long phi(long x) {
        long res = x;
        long t = x;
        for (long p : primes) {
            if (p * p > t) break;
            if (t % p == 0) {
                while (t % p == 0) t /= p;
                res = res / p * (p - 1);
            }
        }
        if (t > 1) res = res / t * (t - 1);
        return res % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long temp = n;
        for (long p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                int cnt = 0;
                while (temp % p == 0) {
                    temp /= p;
                    cnt++;
                }
                primes.add(p);
                powers.add(cnt);
            }
        }
        if (temp > 1) {
            primes.add(temp);
            powers.add(1);
        }

        gen(0, 1);

        long ans = 1;
        for (long d : divisors) {
            ans = (ans * phi(d)) % MOD;
        }

        System.out.println(ans);
    }
}
