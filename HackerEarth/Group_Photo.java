import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        int[] w = new int[n];
        int[] h = new int[n];

        long totalWidth = 0;
        int max1 = 0; // Largest height
        int max2 = 0; // Second largest height

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());

            totalWidth += w[i];

            // Maintain top two maximum heights
            if (h[i] > max1) {
                max2 = max1;
                max1 = h[i];
            } else if (h[i] > max2) {
                max2 = h[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long currentWidth = totalWidth - w[i];
            long currentHeight = (h[i] == max1) ? max2 : max1;
            long area = currentWidth * currentHeight;
            
            sb.append(area).append(i == n - 1 ? "" : " ");
        }

        System.out.println(sb.toString());
    }
}
