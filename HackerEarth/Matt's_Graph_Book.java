import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        int k = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int x = Integer.parseInt(br.readLine().trim());

        // Handle edge case where removing x leaves 0 or 1 node
        if (n <= 2) {
            System.out.println("Connected");
            return;
        }

        // Pick a starting node that is not x
        int startNode = (x == 0) ? 1 : 0;

        boolean[] visited = new boolean[n];
        visited[x] = true; // Mark removed node as visited so it won't be traversed

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visitedCount++;

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        if (visitedCount == n - 1) {
            System.out.println("Connected");
        } else {
            System.out.println("Not Connected");
        }
    }
}
