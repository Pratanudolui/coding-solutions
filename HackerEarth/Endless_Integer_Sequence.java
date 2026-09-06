import java.io.*;
import java.util.*;

public class Main {

    static class FenwickTree {
        private final int size;
        private final int[] tree;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        public void add(int i, int delta) {
            for (; i <= size; i += i & -i) {
                tree[i] += delta;
            }
        }

        public int query(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) {
                sum += tree[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        List<Long> deletedList = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            if (queries[i][0] == 1) {
                deletedList.add((long) queries[i][1]);
            }
        }

        // Coordinate compression on deleted elements
        long[] deletedArr = deletedList.stream().mapToLong(Long::longValue).sorted().distinct().toArray();
        int n = deletedArr.length;

        FenwickTree bit = new FenwickTree(n);

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            long val = queries[i][1];

            if (type == 1) {
                // Find index of val in coordinate compressed array
                int idx = Arrays.binarySearch(deletedArr, val);
                if (idx >= 0) {
                    bit.add(idx + 1, 1);
                }
            } else {
                // Binary search for the K-th smallest element
                long low = 1;
                long high = val + q; // Upper bound since at most Q elements are deleted
                long ans = high;

                while (low <= high) {
                    long mid = low + (high - low) / 2;

                    // Number of deleted elements <= mid
                    int countDeleted = 0;
                    int upperBoundIdx = upperBound(deletedArr, mid);
                    if (upperBoundIdx > 0) {
                        countDeleted = bit.query(upperBoundIdx);
                    }

                    long remainingCount = mid - countDeleted;

                    if (remainingCount >= val) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                out.println(ans);
            }
        }

        out.flush();
    }

    // Returns count of elements <= key
    private static int upperBound(long[] arr, long key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
