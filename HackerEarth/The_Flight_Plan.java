import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int c = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int src = sc.nextInt() - 1;
        int dest = sc.nextInt() - 1;

        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i));
        }

        Stack<Integer> path = getPath(graph, src, dest, n);
       
        System.out.println(path.size());
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

    private static Stack<Integer> getPath(List<List<Integer>> graph, int src, int dest, int n) {
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;
        parent[src] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == dest) break;
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        Stack<Integer> path = new Stack<>();
        int i = dest;

        path.push(dest + 1);

        while (i != src) {
            path.push(parent[i] + 1);
            i = parent[i];
        }

        return path;
    }
}
