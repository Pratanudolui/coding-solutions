import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestClass {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int N = Integer.parseInt(line.trim());

        String[] times = br.readLine().trim().split(" ");
        int startSec = parseTime(times[0]);
        int endSec = parseTime(times[1]);

        int[] diff = new int[86402];
        boolean[] sid1Present = new boolean[86402];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sid = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int k = 0; k < m; k++) {
                int arrival = parseTime(st.nextToken());
                int leave = parseTime(st.nextToken());

                diff[arrival]++;
                diff[leave]--;

                if (sid == 1) {
                    for (int s = arrival; s < leave; s++) {
                        sid1Present[s] = true;
                    }
                }
            }
        }

        int currentCount = 0;
        int minStudents = Integer.MAX_VALUE;

        // First pass: find the minimum student count during the class period
        for (int s = 0; s < 86400; s++) {
            currentCount += diff[s];
            if (s >= startSec && s < endSec) {
                if (currentCount < minStudents) {
                    minStudents = currentCount;
                }
            }
        }

        // Second pass: count matching minimum seconds and SID=1 presence
        long P = 0;
        long Q = 0;
        currentCount = 0;

        for (int s = 0; s < 86400; s++) {
            currentCount += diff[s];
            if (s >= startSec && s < endSec) {
                if (currentCount == minStudents) {
                    Q++;
                    if (sid1Present[s]) {
                        P++;
                    }
                }
            }
        }

        if (P == 0) {
            System.out.println(0);
        } else {
            long g = gcd(P, Q);
            System.out.println((P / g) + "/" + (Q / g));
        }
    }

    private static int parseTime(String t) {
        String[] parts = t.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
