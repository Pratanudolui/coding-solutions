import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
       
        while (T-- > 0) {
            int units = sc.nextInt();
            int N = sc.nextInt();
           
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
           
            int i;
            for (i = 0; i < N; i++) {
                if (arr[i] == 0) {
                    units--;
                }
                if (arr[i] == 1) {
                    units += 2;
                }
               
                if (units == 0 && i != N - 1) {
                    System.out.println("No " + (i + 1));
                    break;
                }
                if (units != 0 && i == N - 1) {
                    System.out.println("Yes " + units);
                    break;
                }
                if (units == 0 && i == N - 1) {
                    System.out.println("Yes " + units);
                }
            }
        }
    }
}
