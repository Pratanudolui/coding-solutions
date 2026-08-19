import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n1 = Long.parseLong(st.nextToken());
            long n2 = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            sb.append(solve(n1, n2, x, y)).append("\n");
        }
        System.out.print(sb);
    }

    private static long solve(long n1, long n2, long x, long y) {
        long lcm = (x / gcd(x, y)) * y; // x and y are prime, so lcm = x * y
        
        long low = 1;
        long high = 2 * (n1 + n2);
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isValid(mid, n1, n2, x, y, lcm)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid n
            } else {
                low = mid + 1;  // Try a larger n
            }
        }
        return ans;
    }

    private static boolean isValid(long n, long n1, long n2, long x, long y, long lcm) {
        long divX = n / x;
        long divY = n / y;
        long divLCM = n / lcm;

        // Numbers available to Bunty (not divisible by x)
        long availableForBunty = n - divX;
        
        // Numbers available to Bublee (not divisible by y)
        long availableForBublee = n - divY;
        
        // Numbers available to either (not divisible by both x and y)
        long availableTotal = n - divLCM;

        return (availableForBunty >= n1) && 
               (availableForBublee >= n2) && 
               (availableTotal >= n1 + n2);
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
