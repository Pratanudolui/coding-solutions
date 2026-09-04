import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            long minClouds = (l + s - 1) / s;
            long maxClouds = r / s;

            if (minClouds > maxClouds) {
                sb.append("-1 -1\n");
            } else {
                sb.append(minClouds).append(" ").append(maxClouds).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
