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
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class DSU {
        int[] p, r;

        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            while (p[x] != x) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return x;
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) {
                p[a] = b;
            } else if (r[a] > r[b]) {
                p[b] = a;
            } else {
                p[b] = a;
                r[a]++;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[] a = new int[n];
        int max = 0;

        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            max = Math.max(max, a[i]);
            pos.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
        }

        ArrayList<Integer>[] bucket = new ArrayList[max + 1];

        for (Map.Entry<Integer, List<Integer>> e : pos.entrySet()) {
            int val = e.getKey();
            for (int d = 1; d * d <= val; d++) {
                if (val % d == 0) {
                    if (bucket[d] == null) bucket[d] = new ArrayList<>();
                    bucket[d].addAll(e.getValue());

                    int d2 = val / d;
                    if (d2 != d) {
                        if (bucket[d2] == null) bucket[d2] = new ArrayList<>();
                        bucket[d2].addAll(e.getValue());
                    }
                }
            }
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int d = 1; d <= max; d++) {
            if (bucket[d] == null || bucket[d].size() < 2) continue;

            ArrayList<Integer> list = bucket[d];
            for (int i = 1; i < list.size(); i++) {
                edges.add(new Edge(list.get(i - 1), list.get(i), d));
            }
        }

        edges.sort((x, y) -> Integer.compare(y.w, x.w));

        DSU dsu = new DSU(n);

        long ans = 0;
        int used = 0;

        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                ans += e.w;
                used++;
                if (used == n - 1) break;
            }
        }

        System.out.println(ans);
    }
}
