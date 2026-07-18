import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long r = Long.parseLong(st.nextToken());
        long g = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[] arr = {r, g, b};
        Arrays.sort(arr);

        long total = arr[1];
        long diff = arr[2] - arr[1];

        if (diff % 2 == 0) {
            total += diff / 2;
        } else {
            total += diff / 2 + 1;
        }

        System.out.println(total);
    }
}
