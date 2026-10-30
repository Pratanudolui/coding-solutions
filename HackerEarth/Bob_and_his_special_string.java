import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        String s = br.readLine().trim();

        int[] freq = new int[26];
        int maxFreq = 0;
        int distinctCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (freq[idx] == 0) {
                distinctCount++;
            }
            freq[idx]++;
            if (freq[idx] > maxFreq) {
                maxFreq = freq[idx];
            }
        }

        // If distinct characters exceed n, it's impossible, but constraints state distinct <= n.
        // Binary search for the minimum multiplier x
        int low = 1, high = maxFreq;
        int ans = maxFreq;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long requiredLength = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    // Ceiling division of freq[i] by mid
                    requiredLength += (freq[i] + mid - 1) / mid;
                }
            }

            if (requiredLength <= n) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid x
            } else {
                low = mid + 1; // Need a larger x to reduce string length per repetition
            }
        }

        System.out.println(ans);
    }
}
