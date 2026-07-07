import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long mn = Long.MAX_VALUE;
            long mx = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
                if (x < mn) mn = x;
                if (x > mx) mx = x;
            }

            out.append(mn + mx).append('\n');
        }

        System.out.print(out);
    }
}
