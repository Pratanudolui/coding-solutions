import java.io.*;
import java.util.*;

public class TestClass {
    static int n;
    static String[] chunks;
    static TreeSet<String> results = new TreeSet<>();
    static int[] path;
    static boolean[] visited;
    static Map<String, List<Integer>> prefixMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        n = Integer.parseInt(line.trim());
        chunks = new String[n];
        prefixMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            chunks[i] = br.readLine().trim();
            if (chunks[i].length() >= 4) {
                String prefix = chunks[i].substring(0, 4);
                prefixMap.computeIfAbsent(prefix, k -> new ArrayList<>()).add(i);
            }
        }

        path = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            path[0] = i;
            String suffix = chunks[i].length() >= 4 ? chunks[i].substring(chunks[i].length() - 4) : "";
            dfs(1, suffix);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (String res : results) {
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int depth, String lastSuffix) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder(chunks[path[0]]);
            for (int i = 1; i < n; i++) {
                String c = chunks[path[i]];
                sb.append(c.substring(4));
            }
            results.add(sb.toString());
            return;
        }

        List<Integer> candidates = prefixMap.get(lastSuffix);
        if (candidates == null) return;

        for (int i = 0; i < candidates.size(); i++) {
            int nextIdx = candidates.get(i);
            if (!visited[nextIdx]) {
                visited[nextIdx] = true;
                path[depth] = nextIdx;
                String nextChunk = chunks[nextIdx];
                String nextSuffix = nextChunk.length() >= 4 ? nextChunk.substring(nextChunk.length() - 4) : "";
                
                dfs(depth + 1, nextSuffix);
                
                visited[nextIdx] = false;
            }
        }
    }
}
