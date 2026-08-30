import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < Q; i++) {
            int X = Integer.parseInt(br.readLine().trim());
            if (set.contains(X)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        out.flush();
    }
}
