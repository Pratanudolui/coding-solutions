import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int x = 0;
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }
            return x;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int[] a = new int[n];
        int mx = 0;

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            if (a[i] > mx) mx = a[i];
        }

        int[] div = new int[mx + 1];
        for (int i = 1; i <= mx; i++)
            for (int j = i; j <= mx; j += i)
                div[j]++;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : a)
            map.put(div[x], map.getOrDefault(div[x], 0) + 1);

        long ans = 0;
        for (int f : map.values())
            ans += 1L * f * (f - 1) / 2;

        System.out.println(ans);
    }
}
