import java.io.*;

public class TestClass {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());

        for (int a = n - 2; a >= 1; a--) {
            if (gcd(a, n) == 1) {
                System.out.println(a);
                return;
            }
        }
    }
}
