import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int M = Integer.parseInt(line.trim());
        int[] arr = new int[M];
        
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            while (s == null || s.trim().isEmpty()) {
                s = br.readLine();
            }
            arr[i] = Integer.parseInt(s.trim());
        }

        // Sort to get non-negative adjacent differences
        Arrays.sort(arr);

        // Find GCD of all adjacent differences
        int overallGcd = arr[1] - arr[0];
        for (int i = 2; i < M; i++) {
            overallGcd = gcd(overallGcd, arr[i] - arr[i - 1]);
        }

        // Find all divisors of overallGcd that are > 1
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= overallGcd; i++) {
            if (overallGcd % i == 0) {
                if (i > 1) {
                    divisors.add(i);
                }
                if (i * i != overallGcd && (overallGcd / i) > 1) {
                    divisors.add(overallGcd / i);
                }
            }
        }

        // Sort divisors in increasing order
        Collections.sort(divisors);

        // Print results separated by space
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < divisors.size(); i++) {
            sb.append(divisors.get(i));
            if (i < divisors.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
