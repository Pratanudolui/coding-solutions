import java.io.*;
import java.util.*;

public class Solution {
    static final long INF = Long.MAX_VALUE / 2;
    record Edge(int to, long weight) {}
    record Node(int u, long dist) implements Comparable<Node> {
        public int compareTo(Node o) { return Long.compare(this.dist, o.dist); }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        Integer tObj = sc.nextInt();
        if (tObj == null) return;
        int T = tObj;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = sc.nextInt(), M = sc.nextInt();
            long[] A = sc.nextLongArray(N), B = sc.nextLongArray(N);

            List<List<Edge>> g1 = sc.nextGraph(N, M), g2 = sc.nextGraph(N, M);
            int x = sc.nextInt(), y = sc.nextInt();

            long[] dist1 = dijkstra(N, x, g1), dist2 = dijkstra(N, y, g2);
            long ans = INF;

            for (int i = 1; i <= N; i++) {
                if (dist1[i] == INF) continue;
                for (int j = i; j <= N; j += i) {
                    if (dist2[j] != INF) {
                        ans = Math.min(ans, dist1[i] + A[i] * B[j] + dist2[j]);
                    }
                }
            }
            sb.append(ans >= INF ? -1 : ans).append('\n');
        }
        System.out.print(sb);
    }

    static long[] dijkstra(int n, int start, List<List<Edge>> g) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start] = 0));

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            if (curr.dist > dist[curr.u]) continue;

            for (Edge e : g.get(curr.u)) {
                if (dist[e.to] > dist[curr.u] + e.weight) {
                    dist[e.to] = dist[curr.u] + e.weight;
                    pq.add(new Node(e.to, dist[e.to]));
                }
            }
        }
        return dist;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        Integer nextInt() throws IOException {
            String s = next();
            return s == null ? null : Integer.parseInt(s);
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n + 1];
            for (int i = 1; i <= n; i++) arr[i] = nextLong();
            return arr;
        }

        List<List<Edge>> nextGraph(int n, int m) throws IOException {
            List<List<Edge>> g = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = nextInt(), v = nextInt();
                long w = nextLong();
                g.get(u).add(new Edge(v, w));
                g.get(v).add(new Edge(u, w));
            }
            return g;
        }
    }
}
