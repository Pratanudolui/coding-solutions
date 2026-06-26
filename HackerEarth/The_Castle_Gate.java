import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            long ans = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if ((i ^ j) <= N) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
