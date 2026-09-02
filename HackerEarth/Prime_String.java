import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TestClass {

    // Helper method to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tStr = br.readLine();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr.trim());

        while (t-- > 0) {
            String s = br.readLine();
            if (s == null) break;
            s = s.trim();

            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            int distinctCount = 0;
            boolean isPrimeString = true;

            for (int count : freq) {
                if (count > 0) {
                    distinctCount++;
                    if (!isPrime(count)) {
                        isPrimeString = false;
                    }
                }
            }

            // Check if total distinct characters count is prime
            if (isPrimeString && isPrime(distinctCount)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
