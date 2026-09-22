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

        int n = Integer.parseInt(line.trim());

        int MAX_VAL = 100000;
        int[] first = new int[MAX_VAL + 1];
        int[] last = new int[MAX_VAL + 1];

        Arrays.fill(first, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int val = Integer.parseInt(st.nextToken());

            if (first[val] == -1) {
                first[val] = i;
            }
            last[val] = i;
        }

        int maxLength = 0;
        for (int val = 1; val <= MAX_VAL; val++) {
            if (first[val] != -1) {
                int length = last[val] - first[val] + 1;
                maxLength = Math.max(maxLength, length);
            }
        }

        System.out.println(maxLength);
    }
}
