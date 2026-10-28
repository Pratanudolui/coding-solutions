import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());

        // Precompute numbers up to 704977 that satisfy Jhool's swinging theorem
        int MAX = 704977;
        Map<Integer, Integer> sumCounts = new HashMap<>();

        int limit = (int) Math.cbrt(MAX);
        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                int sum = (a * a * a) + (b * b * b);
                if (sum <= MAX) {
                    sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
                }
            }
        }

        List<Integer> validNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCounts.entrySet()) {
            if (entry.getValue() > 1) {
                validNumbers.add(entry.getKey());
            }
        }
        Collections.sort(validNumbers);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line.trim());

            int ans = -1;
            for (int num : validNumbers) {
                if (num < n) {
                    if (num > ans) {
                        ans = num;
                    }
                } else {
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
