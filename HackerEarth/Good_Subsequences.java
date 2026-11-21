import java.io.*;

class TestClass {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) {
            return;
        }

        int t = Integer.parseInt(firstLine.trim());
        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            if (s == null) {
                s = "";
            } else {
                s = s.trim();
            }

            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                }
            }

            long ways = 1L;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    ways = (ways * freq[i]) % MOD;
                }
            }

            out.append(ways).append('\n');
        }

        System.out.print(out.toString());
    }
}
