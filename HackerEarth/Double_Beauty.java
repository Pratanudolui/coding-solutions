import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a);
            int[] doubled = new int[n];
            for (int i = 0; i < k; i++)
             doubled[i] = a[n - 1 - i] * 2;
            for (int i = k; i < n; i++)
            doubled[i] = a[n - 1 - i + k];
            int maxBeauty = 0;
            int windowSum = 0;
            for (int i = 0; i < k; i++)
            windowSum += doubled[i];
            maxBeauty = windowSum;
            for (int i = k; i < n; i++) {
                windowSum += doubled[i] - doubled[i - k];
                maxBeauty = Math.max(maxBeauty, windowSum);
            }
            System.out.println(maxBeauty);
        }
    }
}
