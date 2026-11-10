import java.io.*;
import java.util.*;

public class TestClass {
    static class Disk implements Comparable<Disk> {
        long r, h;

        Disk(long r, long h) {
            this.r = r;
            this.h = h;
        }

        @Override
        public int compareTo(Disk other) {
            if (this.r != other.r) {
                return Long.compare(this.r, other.r);
            }
            return Long.compare(this.h, other.h);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            Disk[] disks = new Disk[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long r = Long.parseLong(st.nextToken());
                long h = Long.parseLong(st.nextToken());
                disks[i] = new Disk(r, h);
            }

            // Sort disks by radius ascending
            Arrays.sort(disks);

            long[] dp = new long[n];
            long maxHeight = 0;

            for (int i = 0; i < n; i++) {
                dp[i] = disks[i].h;
                for (int j = 0; j < i; j++) {
                    // Disk j can be below Disk i if both radius and height of j are strictly greater than i
                    // Wait, the rule says: "in order to put disk A on top of disk B, the radius and height of A must be strictly smaller than those of B."
                    // Therefore, disks[i] (A) is on top of disks[j] (B) if disks[i].r < disks[j].r AND disks[i].h < disks[j].h.
                    if (disks[i].r > disks[j].r && disks[i].h > disks[j].h) {
                        dp[i] = Math.max(dp[i], dp[j] + disks[i].h);
                    }
                }
                maxHeight = Math.max(maxHeight, dp[i]);
            }

            sb.append(maxHeight).append("\n");
        }

        System.out.print(sb);
    }
}
