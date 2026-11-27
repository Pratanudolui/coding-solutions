import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String tLine = nextNonEmptyLine(br);
        if (tLine == null) return;
        int t = Integer.parseInt(tLine.trim());

        StringBuilder out = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            String mLine = nextNonEmptyLine(br);
            if (mLine == null) break;
            int m = Integer.parseInt(mLine.trim());

            long mod9Sum = 0L;
            boolean hasNonZero = false;

            for (int i = 0; i < m; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    String line = nextNonEmptyLine(br);
                    if (line == null) break;
                    st = new StringTokenizer(line);
                }
                if (st == null || !st.hasMoreTokens()) break;

                long len = Long.parseLong(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if (d > 0) {
                    hasNonZero = true;
                }
                long blockMod = ((len % 9L) * (d % 9L)) % 9L;
                mod9Sum = (mod9Sum + blockMod) % 9L;
            }

            int ans;
            if (!hasNonZero) {
                ans = 0;
            } else {
                ans = (mod9Sum == 0L) ? 9 : (int) mod9Sum;
            }
            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }

    private static String nextNonEmptyLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        return line;
    }
}
