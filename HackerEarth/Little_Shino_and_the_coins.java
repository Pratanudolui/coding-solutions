import java.io.*;

public class Main {

    static long atMost(String s, int k) {
        if (k < 0) return 0;

        int[] freq = new int[26];
        int left = 0, distinct = 0;
        long ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            if (freq[c]++ == 0) distinct++;

            while (distinct > k) {
                int x = s.charAt(left++) - 'a';
                if (--freq[x] == 0) distinct--;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(atMost(s, k) - atMost(s, k - 1));
    }
}
