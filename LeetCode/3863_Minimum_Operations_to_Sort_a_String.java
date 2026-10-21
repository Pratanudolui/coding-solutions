class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if (n == 2 && s.charAt(0) > s.charAt(1)) {
            return -1;
        }

        boolean sorted = true;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        char mn = s.charAt(1);
        char mx = s.charAt(1);

        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);

            mn = (char) Math.min(mn, ch);
            mx = (char) Math.max(mx, ch);
        }

        char left = s.charAt(0);
        char right = s.charAt(n - 1);

        if (left <= Math.min(right, mn) ||
            right >= Math.max(left, mx)) {
            return 1;
        } else if (right >= mn || left <= mx) {
            return 2;
        } else {
            return 3;
        }
    }
}
