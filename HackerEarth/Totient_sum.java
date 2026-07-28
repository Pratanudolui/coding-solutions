import java.io.*;

public class Main {

    static final int MEX = 200000;
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] etf = new long[MEX];

        for (int i = 1; i < MEX; i++)
            etf[i] = i;

        for (int i = 2; i < MEX; i++) {
            if (etf[i] == i) {
                for (int j = i; j < MEX; j += i) {
                    etf[j] *= (i - 1);
                    etf[j] /= i;
                }
            }
        }

        long sum = 0;

        for (int i = 1; i < MEX; i++) {
            sum = (sum + etf[i]) % MOD;
            etf[i] = (etf[i - 1] + (sum * etf[i]) % MOD) % MOD;
        }

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(etf[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
