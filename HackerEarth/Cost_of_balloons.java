import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int T = Integer.parseInt(line.trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int costGreen = Integer.parseInt(st.nextToken());
            int costPurple = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine().trim());
            int count1 = 0;
            int count2 = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                if (p1 == 1) count1++;
                if (p2 == 1) count2++;
            }

            int option1 = count1 * costGreen + count2 * costPurple;
            int option2 = count1 * costPurple + count2 * costGreen;

            System.out.println(Math.min(option1, option2));
        }
    }
}
