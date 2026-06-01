import java.io.*;
import java.util.*;

public class Main {

    static boolean can(int k, long[] arr, long[] cost, long d) {
        long need = 0;

        int n = arr.length;

        for (int i = 0; i < k; i++) {
            long customer = arr[n - k + i];
            long item = cost[i];

            if (item > customer)
                need += item - customer;

            if (need > d)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");

        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        long d = Long.parseLong(first[2]);

        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long[] cost = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        Arrays.sort(arr);
        Arrays.sort(cost);

        int lo = 0;
        int hi = Math.min(N, M);
        int ans = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (can(mid, arr, cost, d)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        long totalCost = 0;

        for (int i = 0; i < ans; i++)
            totalCost += cost[i];

        long minSpent = Math.max(0, totalCost - d);

        System.out.println(ans + " " + minSpent);
    }
}
