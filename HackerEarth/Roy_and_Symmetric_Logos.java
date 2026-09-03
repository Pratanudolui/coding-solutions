import java.io.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tInput = br.readLine();
        if (tInput == null || tInput.trim().isEmpty()) return;
        
        int T = Integer.parseInt(tInput.trim());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            char[][] matrix = new char[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i] = br.readLine().trim().toCharArray();
            }

            boolean isSymmetric = true;

            for (int r = 0; r < N && isSymmetric; r++) {
                for (int c = 0; c < N; c++) {
                    // Check symmetry across X-axis and Y-axis
                    if (matrix[r][c] != matrix[N - 1 - r][c] || matrix[r][c] != matrix[r][N - 1 - c]) {
                        isSymmetric = false;
                        break;
                    }
                }
            }

            if (isSymmetric) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
