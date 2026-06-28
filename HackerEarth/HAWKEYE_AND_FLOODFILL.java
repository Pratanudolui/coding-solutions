import java.util.*;

class TestClass {

    public static int abs(int x) {
        return x < 0 ? -x : x;
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int p = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int x = p - abs(a - i);
                int y = p - abs(b - j);

                if (x <= y && x >= 0)
                    sb.append(x);
                else if (x > y && y >= 0)
                    sb.append(y);
                else
                    sb.append(0);

                if (j != n - 1)
                    sb.append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
