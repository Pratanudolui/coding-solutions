import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long p = sc.nextLong();

        int count = 0;

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();

            p -= x;
            count++;

            if (p <= 0) {
                System.out.println(count);
                return;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
