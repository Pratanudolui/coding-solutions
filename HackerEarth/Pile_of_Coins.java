import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            // Jeel wins if both P and Q are odd. Otherwise, Ashish wins.
            if (p % 2 != 0 && q % 2 != 0) {
                wr.println("Jeel");
            } else {
                wr.println("Ashish");
            }
        }
        wr.flush();
    }
}
