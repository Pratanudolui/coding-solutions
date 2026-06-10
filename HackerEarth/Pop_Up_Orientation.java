import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        while (num-- > 0) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();

            if ((e + c <= a) && (f - d >= 0)) {
                System.out.println("bottom-right");
            } 
            else if ((e - c >= 0) && (f - d >= 0)) {
                System.out.println("bottom-left");
            } 
            else if ((e + c <= a) && (f + d <= b)) {
                System.out.println("top-right");
            } 
            else if (a == 1 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
                System.out.println("bottom-right");
            } 
            else {
                System.out.println("top-left");
            }
        }

        sc.close();
    }
}
