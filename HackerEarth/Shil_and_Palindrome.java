import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            System.out.println(-1);
            return;
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (odd == 1) {
            ans.append(mid);
        }

        ans.append(left.reverse());

        System.out.println(ans);
    }
}
