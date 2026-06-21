import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long moves = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1]) {
                long need = a[i - 1] + 1;
                moves += need - a[i];
                a[i] = need;
            }
        }

        System.out.println(moves);
    }
}
