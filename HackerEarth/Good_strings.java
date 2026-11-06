import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] maskCount = new long[4];

            for (int i = 0; i < n; i++) {
                String s = br.readLine().trim();
                int mask = 0;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (ch == '0') {
                        mask |= 1;
                    } else if (ch == '1') {
                        mask |= 2;
                    }
                }
                maskCount[mask]++;
            }

            long totalPairs = (long) n * (n - 1) / 2;
            long badPairs = 0;

            for (int i = 0; i < 4; i++) {
                if (maskCount[i] == 0) continue;
                for (int j = i; j < 4; j++) {
                    if (maskCount[j] == 0) continue;
                    
                    if ((i & j) == 0) {
                        if (i == j) {
                            badPairs += maskCount[i] * (maskCount[i] - 1) / 2;
                        } else {
                            badPairs += maskCount[i] * maskCount[j];
                        }
                    }
                }
            }

            long goodPairs = totalPairs - badPairs;
            sb.append(goodPairs).append("\n");
        }

        System.out.print(sb);
    }
}
