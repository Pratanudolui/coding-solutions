import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int q = queries.length;
        Integer[] idx = new Integer[q];
        for (int i = 0; i < q; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] cnt = new int[n + 1];
        int[] res = new int[q];
        int distinct = 0, l = 0, r = 0;

        for (int id : idx) {
            int t = queries[id];
            while (r < logs.length && logs[r][1] <= t) {
                if (cnt[logs[r][0]]++ == 0) distinct++;
                r++;
            }
            while (l < r && logs[l][1] < t - x) {
                if (--cnt[logs[l][0]] == 0) distinct--;
                l++;
            }
            res[id] = n - distinct;
        }
        return res;
    }
}
