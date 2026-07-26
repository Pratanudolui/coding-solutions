import java.util.*;

class TestClass {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int ans = 0;

        int N = sc.nextInt();

        int arr[] = new int[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        for (int i = 1; i <= N; i++) {

            if (i + arr[i] > N) {
                ans = i;
                break;
            }

        }

        System.out.println(ans);
    }

}
