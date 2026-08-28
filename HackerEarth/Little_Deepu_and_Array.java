import java.io.InputStream;
import java.util.Arrays;

public class TestClass {
    static class Pair implements Comparable<Pair> {
        int val, originalIndex;

        Pair(int val, int originalIndex) {
            this.val = val;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }

    static int[] treeMin;
    static int[] treeMax;
    static int[] lazy;

    static void build(int node, int start, int end, Pair[] arr) {
        if (start == end) {
            treeMin[node] = arr[start].val;
            treeMax[node] = arr[start].val;
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        treeMin[node] = Math.min(treeMin[2 * node], treeMin[2 * node + 1]);
        treeMax[node] = Math.max(treeMax[2 * node], treeMax[2 * node + 1]);
    }

    static void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            treeMin[node] -= lazy[node];
            treeMax[node] -= lazy[node];
            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int val) {
        push(node, start, end);
        if (treeMax[node] <= val) {
            return;
        }
        if (treeMin[node] > val) {
            lazy[node] += 1;
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(2 * node, start, mid, val);
        update(2 * node + 1, mid + 1, end, val);
        treeMin[node] = Math.min(treeMin[2 * node], treeMin[2 * node + 1]);
        treeMax[node] = Math.max(treeMax[2 * node], treeMax[2 * node + 1]);
    }

    static void queryAndStore(int node, int start, int end, Pair[] arr, int[] ans) {
        push(node, start, end);
        if (start == end) {
            ans[arr[start].originalIndex] = treeMin[node];
            return;
        }
        int mid = (start + end) / 2;
        queryAndStore(2 * node, start, mid, arr, ans);
        queryAndStore(2 * node + 1, mid + 1, end, arr, ans);
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        Integer nObj = sc.nextInt();
        if (nObj == null) return;
        int n = nObj;

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextInt(), i);
        }

        Arrays.sort(arr);

        treeMin = new int[4 * n];
        treeMax = new int[4 * n];
        lazy = new int[4 * n];

        build(1, 0, n - 1, arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            update(1, 0, n - 1, x);
        }

        int[] ans = new int[n];
        queryAndStore(1, 0, n - 1, arr, ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(i == n - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[32768];
        private int ptr = 0;
        private int buflen = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws Exception {
            if (ptr >= buflen) {
                ptr = 0;
                buflen = in.read(buffer, 0, buffer.length);
                if (buflen <= 0) return -1;
            }
            return buffer[ptr++];
        }

        public Integer nextInt() throws Exception {
            int c = read();
            while (c <= 32) {
                if (c == -1) return null;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') {
                    c = read();
                    continue;
                }
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }
}
