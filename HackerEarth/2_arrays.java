import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());

        long sumA = 0;
        int minusOneCountA = 0;
        int[] a = new int[n];
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] == -1) {
                minusOneCountA++;
            } else {
                sumA += a[i];
            }
        }

        long sumB = 0;
        int minusOneCountB = 0;
        int[] b = new int[n];
        line = br.readLine();
        st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i] == -1) {
                minusOneCountB++;
            } else {
                sumB += b[i];
            }
        }

        int totalMinusOnes = minusOneCountA + minusOneCountB;

        if (totalMinusOnes == 1) {
            // Exactly one -1 present
            if (minusOneCountA == 1) {
                // The -1 is in A. We need sumA + X = sumB => X = sumB - sumA
                long required = sumB - sumA;
                if (required >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                // The -1 is in B. We need sumA = sumB + X => X = sumA - sumB
                long required = sumA - sumB;
                if (required >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        } else {
            // Exactly two -1s present
            if (minusOneCountA == 2) {
                // Both -1s are in A. A_sum + X1 + X2 = sumB => X1 + X2 = sumB - sumA
                long target = sumB - sumA;
                if (target < 0) {
                    System.out.println(0);
                } else {
                    // Number of non-negative integer solutions for X1 + X2 = target is target + 1
                    System.out.println(target + 1);
                }
            } else if (minusOneCountB == 2) {
                // Both -1s are in B. sumA = B_sum + X1 + X2 => X1 + X2 = sumA - sumB
                long target = sumA - sumB;
                if (target < 0) {
                    System.out.println(0);
                } else {
                    System.out.println(target + 1);
                }
            } else {
                // One -1 in A and one -1 in B. X_A = X_B + (sumB - sumA) or similar.
                // Since they can grow infinitely, the answer is Infinite.
                System.out.println("Infinite");
            }
        }
    }
}
