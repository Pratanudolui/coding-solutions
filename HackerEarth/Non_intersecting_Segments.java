import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        long[] x1 = new long[n];
        long[] y1 = new long[n];
        long[] x2 = new long[n];
        long[] y2 = new long[n];

        long[][] a = new long[n][2];
        long[][] b = new long[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1[i] = Long.parseLong(st.nextToken());
            y1[i] = Long.parseLong(st.nextToken());
            x2[i] = Long.parseLong(st.nextToken());
            y2[i] = Long.parseLong(st.nextToken());

            a[i][0] = x1[i]; a[i][1] = y1[i];
            b[i][0] = x2[i]; b[i][1] = y2[i];
        }

        Arrays.sort(a, (p1, p2) -> p1[0] != p2[0] ? Long.compare(p1[0], p2[0]) : Long.compare(p1[1], p2[1]));
        Arrays.sort(b, (p1, p2) -> p1[0] != p2[0] ? Long.compare(p1[0], p2[0]) : Long.compare(p1[1], p2[1]));

        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            long[] p1 = new long[]{x1[i], y1[i]};
            long[] p2 = new long[]{x2[i], y2[i]};

            int pos1 = binarySearch(a, p1);
            int pos2 = binarySearch(b, p2);

            v[pos1] = pos2;
        }

        // LIS computation
        long[] c = new long[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(c, 0, len, v[i]);
            if (idx < 0) idx = -idx - 1;
            c[idx] = v[i];
            if (idx == len) len++;
        }

        System.out.println(len);
    }

    static int binarySearch(long[][] arr, long[] target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid][0] == target[0] && arr[mid][1] == target[1]) {
                return mid;
            } else if (arr[mid][0] < target[0] || (arr[mid][0] == target[0] && arr[mid][1] < target[1])) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
