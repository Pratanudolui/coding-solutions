import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        String s = br.readLine().trim();

        int[] A = new int[26];
        int[] B = new int[26];

        int half = n / 2;
        for (int i = 0; i < half; i++) {
            A[s.charAt(i) - 'a']++;
            B[s.charAt(i + half) - 'a']++;
        }

        int c1 = solveCase1(A, B);
        int c2 = solveCase2(A, B);
        int c3 = solveCase3(A, B, n);

        System.out.println(Math.min(c1, Math.min(c2, c3)));
    }

    private static int solveCase1(int[] a, int[] b) {
        int[] A = a.clone();
        int[] B = b.clone();
        int ans = A[0];
        A[25] += ans;
        A[0] = 0;

        for (int i = 1; i < 26; i++) {
            int req = A[i];
            for (int j = 0; j < i; j++) {
                if (B[j] >= req) {
                    B[j] -= req;
                    req = 0;
                } else {
                    req -= B[j];
                    B[j] = 0;
                }
                if (req == 0) break;
            }
            ans += req;
        }
        return ans;
    }

    private static int solveCase2(int[] a, int[] b) {
        int[] A = a.clone();
        int[] B = b.clone();
        int ans = A[25];
        A[0] += ans;
        A[25] = 0;

        for (int i = 24; i >= 0; i--) {
            int req = A[i];
            for (int j = i + 1; j < 26; j++) {
                if (B[j] >= req) {
                    B[j] -= req;
                    req = 0;
                } else {
                    req -= B[j];
                    B[j] = 0;
                }
                if (req == 0) break;
            }
            ans += req;
        }
        return ans;
    }

    private static int solveCase3(int[] a, int[] b, int n) {
        int common = 0;
        for (int i = 0; i < 26; i++) {
            common += Math.min(a[i], b[i]);
        }
        return (n / 2) - common;
    }
}
