import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int l = Integer.parseInt(line.trim());
        int n = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w < l || h < l) {
                sb.append("UPLOAD ANOTHER\n");
            } else if (w == h) {
                sb.append("ACCEPTED\n");
            } else {
                sb.append("CROP IT\n");
            }
        }

        System.out.print(sb);
    }
}
