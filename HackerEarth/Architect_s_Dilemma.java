import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long w = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        int idx = 0;
        while (idx < n) {
            String arrLine = br.readLine();
            if (arrLine == null) break;
            StringTokenizer arrSt = new StringTokenizer(arrLine);
            while (arrSt.hasMoreTokens() && idx < n) {
                a[idx++] = Long.parseLong(arrSt.nextToken());
            }
        }

        Arrays.sort(a);

        int left = 0;
        long windowSum = 0;
        int maxWorkers = 0;

        for (int right = 0; right < n; right++) {
            windowSum += a[right];

            while (a[right] * (right - left + 1L) - windowSum > w) {
                windowSum -= a[left];
                left++;
            }

            int currentCount = right - left + 1;
            if (currentCount > maxWorkers) {
                maxWorkers = currentCount;
            }
        }

        System.out.println(maxWorkers);
    }
}
