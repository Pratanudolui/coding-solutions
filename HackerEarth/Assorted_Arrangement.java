import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] c = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[] color = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            color[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        long previous = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int currentColor = color[i];

            long x = ((previous / c[currentColor]) + 1) * c[currentColor];

            while (true) {
                boolean correct = true;

                // The last applicable rule determines the color.
                // So x must NOT be divisible by any c[j] with j > currentColor.
                for (int j = currentColor + 1; j < m; j++) {
                    if (x % c[j] == 0) {
                        correct = false;
                        break;
                    }
                }

                if (correct) {
                    break;
                }

                x += c[currentColor];
            }

            previous = x;
            answer = x;
        }

        System.out.println(answer);
    }
}
