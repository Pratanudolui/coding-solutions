import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        String r = new StringBuilder(s).reverse().toString();

        int n = s.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    maxLen = Math.max(maxLen, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        if (maxLen > 1) {
            System.out.println("YES");
            System.out.println(maxLen);
        } else {
            System.out.println("NO");
        }
    }
}
