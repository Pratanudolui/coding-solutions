class Solution {
    private static final long MOD = 1_000_000_007L;

    private long computeHash(int[] v, int i, int j, long base) {
        long p = 1;
        long ret = 0;
        for (int x = i; x <= j; x++) {
            ret = (ret + (v[x] * p) % MOD) % MOD;
            p = (p * base) % MOD;
        }
        return ret;
    }

    private long binpow(long a, long b) {
        long ret = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                ret = (ret * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ret;
    }

    private boolean check(int[] v, int m) {
        Map<Long, Integer> mp = new HashMap<>();
        long base = 13;
        long x = computeHash(v, 0, m - 1, base);
        long p = binpow(base, m - 1);
        long inv = binpow(base, MOD - 2);

        mp.put(x, 1);

        for (int i = 0, j = m; j < v.length; i++, j++) {
            x = ((x - v[i]) % MOD + MOD) % MOD;
            x = (x * inv) % MOD;
            x = (x + (v[j] * p) % MOD) % MOD;
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        for (int count : mp.values()) {
            if (count == 1) return true;
        }
        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int low = 1, high = nums.length, ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
