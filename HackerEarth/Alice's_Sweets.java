import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int N = Integer.parseInt(line.trim());

        int[] A = parseArray(br.readLine(), N);
        int[] B = parseArray(br.readLine(), N);
        int[] C = parseArray(br.readLine(), N);

        System.out.println(solve(N, A, B, C));
    }

    private static int[] parseArray(String line, int N) {
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static long solve(int N, int[] A, int[] B, int[] C) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        int i = 0, j = 0, k = 0;
        long minDiff = Long.MAX_VALUE;

        while (i < N && j < N && k < N) {
            int currentA = A[i];
            int currentB = B[j];
            int currentC = C[k];

            int minVal = Math.min(currentA, Math.min(currentB, currentC));
            int maxVal = Math.max(currentA, Math.max(currentB, currentC));

            long currentDiff = 2L * (maxVal - minVal);
            minDiff = Math.min(minDiff, currentDiff);

            // Advance the pointer pointing to the minimum value
            if (minVal == currentA) {
                i++;
            } else if (minVal == currentB) {
                j++;
            } else {
                k++;
            }
        }

        return minDiff;
    }
}
