import java.io.*;
import java.util.*;

public class Main {
    // Binary Indexed Tree (Fenwick Tree) to maintain set-bit counts
    static class FenwickTree {
        private final int[] tree;
        private final int size;

        public FenwickTree(int n) {
            this.size = n;
            this.tree = new int[n + 1];
        }

        public void update(int index, int delta) {
            for (; index <= size; index += index & -index) {
                tree[index] += delta;
            }
        }

        public int query(int index) {
            int sum = 0;
            for (; index > 0; index -= index & -index) {
                sum += tree[index];
            }
            return sum;
        }

        public int queryRange(int l, int r) {
            return query(r) - query(l - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        // Fast IO setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        FenwickTree bit = new FenwickTree(n);
        // Track individual set bit count for each array index
        int[] setBitCount = new int[n + 1]; 

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;

            st = new StringTokenizer(line);
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                setBitCount[x]++;
                bit.update(x, 1);
            } else if (type == 2) {
                int x = Integer.parseInt(st.nextToken());
                if (setBitCount[x] > 0) {
                    setBitCount[x]--;
                    bit.update(x, -1);
                }
            } else if (type == 3) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                sb.append(bit.queryRange(x, y)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
