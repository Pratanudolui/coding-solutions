import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] x = br.readLine().toCharArray();
        int n = x.length;

        for (int i = 0; i < n; i++) {
            if (x[i] != '?')
                continue;

            char left = (i > 0) ? x[i - 1] : '\0';
            char right = (i < n - 1) ? x[i + 1] : '\0';

            if (left == 'a' || right == 'a')
                x[i] = 'b';
            else
                x[i] = 'a';
        }

        System.out.println(new String(x));
    }
}
