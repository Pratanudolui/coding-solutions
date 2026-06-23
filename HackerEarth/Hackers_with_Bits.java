import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, z = 0, maxi = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) z++;

            while (z > 1) {
                if (nums[l] == 0) z--;
                l++;
            }

            maxi = Math.max(maxi, r - l + 1);
        }

        int ones = 0;
        for (int x : nums) {
            if (x == 1) ones++;
        }

        System.out.println(ones >= maxi ? maxi : maxi - 1);
    }
}
