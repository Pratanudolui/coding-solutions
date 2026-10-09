import java.io.*;
import java.util.*;

public class TestClass {

    private static char[] labels;
    private static List<Integer>[] adj;
    private static int[][] subtreeCount;

    private static void dfs(int u, int parent) {
        // Base count for node u's own character
        subtreeCount[u][labels[u] - 'a'] = 1;

        for (int v : adj[u]) {
            if (v != parent) {
                dfs(v, u);
                // Aggregate character frequencies from child subtree
                for (int i = 0; i < 26; i++) {
                    subtreeCount[u][i] += subtreeCount[v][i];
                }
            }
        }
    }

    // Fast Scanner for IO efficiency
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024 * 64];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer, 0, buffer.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        public boolean hasNext() {
            int b = readByte();
            while (b != -1 && b <= ' ') {
                b = readByte();
            }
            if (b == -1) return false;
            ptr--;
            return true;
        }

        public String next() {
            if (!hasNext()) return null;
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (b > ' ') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        if (!fs.hasNext()) return;

        int n = fs.nextInt();
        int q = fs.nextInt();

        labels = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            labels[i] = fs.next().charAt(0);
        }

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        subtreeCount = new int[n + 1][26];

        // Precompute subtree character frequencies starting from root node 1
        dfs(1, 0);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int x = fs.nextInt();
            String s = fs.next();

            int[] countS = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                countS[s.charAt(i) - 'a']++;
            }

            int needed = 0;
            for (int i = 0; i < 26; i++) {
                if (countS[i] > subtreeCount[x][i]) {
                    needed += (countS[i] - subtreeCount[x][i]);
                }
            }

            sb.append(needed).append("\n");
        }

        System.out.print(sb);
    }
}
