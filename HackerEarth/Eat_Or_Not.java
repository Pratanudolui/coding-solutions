import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int targetV = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        int targetF = Integer.parseInt(st.nextToken());
        int targetP = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine().trim());
        int[][] fruits = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            fruits[i][0] = Integer.parseInt(st.nextToken());
            fruits[i][1] = Integer.parseInt(st.nextToken());
            fruits[i][2] = Integer.parseInt(st.nextToken());
            fruits[i][3] = Integer.parseInt(st.nextToken());
        }

        // Search over all 2^N subsets
        int totalSubsets = 1 << N;
        for (int mask = 0; mask < totalSubsets; mask++) {
            int sumV = 0, sumC = 0, sumF = 0, sumP = 0;

            for (int i = 0; i < N; i++) {
                if (((mask >> i) & 1) == 1) {
                    sumV += fruits[i][0];
                    sumC += fruits[i][1];
                    sumF += fruits[i][2];
                    sumP += fruits[i][3];
                }
            }

            if (sumV == targetV && sumC == targetC && sumF == targetF && sumP == targetP) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
