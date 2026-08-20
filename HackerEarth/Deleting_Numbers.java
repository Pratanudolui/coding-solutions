import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n+1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }

        int middle = (n+1)/2;
        int N = n-k;
        int Middle = (N+1)/2;
        int End = Middle+k;

        int[] a = Arrays.copyOfRange(A, Middle, End+1);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        System.out.println(max);
    }
}
