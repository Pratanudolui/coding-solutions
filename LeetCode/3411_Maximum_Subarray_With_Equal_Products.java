class Solution {
    public int maxLength(int[] nums) {
        int[] mask = {0, 0, 1, 2, 1, 4, 3, 8, 1, 2, 5};

        int n = nums.length;
        int used = 0, l = 0;
        int ans = 2;

        for (int r = 0; r < n; r++) {
            while ((used & mask[nums[r]]) != 0) {
                used ^= mask[nums[l]];
                l++;
            }
            used |= mask[nums[r]];
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
