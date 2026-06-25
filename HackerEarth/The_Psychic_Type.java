import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int s = sc.nextInt();
        int e = sc.nextInt();

        boolean[] visited = new boolean[n + 1];

        int curr = s;

        while (!visited[curr]) {
            if (curr == e) {
                System.out.println("Yes");
                return;
            }

            visited[curr] = true;
            curr = a[curr];
        }

        System.out.println("No");
    }
}
