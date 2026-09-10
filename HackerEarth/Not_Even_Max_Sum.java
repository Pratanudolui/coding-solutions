import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int T = Integer.parseInt(line.trim());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            long totalSum = 0;
            long minOdd = Long.MAX_VALUE;
            
            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(st.nextToken());
                totalSum += num;
                
                if (num % 2 != 0) {
                    minOdd = Math.min(minOdd, num);
                }
            }
            
            if (totalSum % 2 != 0) {
                System.out.println(totalSum);
            } else if (minOdd != Long.MAX_VALUE) {
                System.out.println(totalSum - minOdd);
            } else {
                System.out.println(0);
            }
        }
    }
}
