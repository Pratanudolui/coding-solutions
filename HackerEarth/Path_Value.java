import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB)
            parent[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException {

        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int m = fr.nextInt();
        int s = fr.nextInt();
        int e = fr.nextInt();

        int[][] edgesRaw = new int[m][2];

        for (int i = 0; i < m; i++) {
            edgesRaw[i][0] = fr.nextInt();
            edgesRaw[i][1] = fr.nextInt();
        }

        int[] values = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = fr.nextInt();
        }

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int u = edgesRaw[i][0];
            int v = edgesRaw[i][1];
            int w = Math.abs(values[u] - values[v]);

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges, (a, b) -> a.w - b.w);

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int ans = 0;

        for (Edge edge : edges) {
            union(edge.u, edge.v);

            if (find(s) == find(e)) {
                ans = edge.w;
                break;
            }
        }

        System.out.println(ans);
    }

    static class FastReader {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
