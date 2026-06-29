import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int ans = 1;

        // Without removing any element
        for (int x : left)
            ans = Math.max(ans, x);

        // Remove first element
        ans = Math.max(ans, right[1]);

        // Remove last element
        ans = Math.max(ans, left[n - 2]);

        // Remove a middle element
        for (int i = 1; i < n - 1; i++) {
            if (a[i - 1] < a[i + 1]) {
                ans = Math.max(ans, left[i - 1] + right[i + 1]);
            } else {
                ans = Math.max(ans, Math.max(left[i - 1], right[i + 1]));
            }
        }

        System.out.println(ans);
    }
}
