import java.io.*;
import java.util.*;

public class TestClass {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean possible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            possible = false;
            for (int i = 1; i <= n; i++) {
                visited = new boolean[n + 1];
                dfs(i, 1, n);
                if (possible) break;
            }

            if (possible) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.print(sb);
    }

    private static void dfs(int u, int count, int n) {
        if (count == n) {
            possible = true;
            return;
        }

        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, count + 1, n);
                if (possible) return;
            }
        }
        visited[u] = false; // Backtrack
    }
}
