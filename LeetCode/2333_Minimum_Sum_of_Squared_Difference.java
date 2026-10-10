class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] d = new int[n + 1];

        long total = 0;

        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            total += d[i];
        }

        if (total <= k)
            return 0;

        Arrays.sort(d, 0, n);

        for (int i = 0; i < n / 2; i++) {
            int temp = d[i];
            d[i] = d[n - 1 - i];
            d[n - 1 - i] = temp;
        }

        d[n] = 0;

        for (int i = 1; i <= n; i++) {
            long cost = (long)(d[i - 1] - d[i]) * i;

            if (cost > k) {
                long q = k / i;
                long r = k % i;
                long hi = d[i - 1] - q;

                long res = hi * hi * (i - r)
                         + (hi - 1) * (hi - 1) * r;

                for (int j = i; j < n; j++)
                    res += (long)d[j] * d[j];

                return res;
            }

            k -= cost;
        }

        return 0;
    }
}
