import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                System.out.println(maxEvenSubarrayLength(n, a));
            }
        }
        sc.close();
    }

    public static int maxEvenSubarrayLength(int n, int[] a) {
        int maxLen = 0;
        int currentLen = 0;
        boolean hasEven = false;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                currentLen++;
                hasEven = true;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                }
            } else {
                currentLen = 0;
            }
        }
        return hasEven ? maxLen : -1;
    }
}
