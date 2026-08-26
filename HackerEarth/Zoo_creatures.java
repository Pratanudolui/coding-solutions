import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {
    
    // Greatest Common Divisor (Euclidean algorithm)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            long g = gcd(a, b);
            
            // ans1 = b / gcd(a, b), ans2 = a / gcd(a, b)
            long ans1 = b / g;
            long ans2 = a / g;
            
            sb.append(ans1).append(" ").append(ans2).append("\n");
        }
        
        System.out.print(sb);
    }
}
