import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] A = new int[2 * n];
        Map<Integer, List<Integer>> v = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Duplicate the array to handle circular wrap-around linearly
        for (int i = n; i < 2 * n; i++) {
            A[i] = A[i - n];
        }

        // Store all indices for each university in sorted order
        for (int i = 0; i < 2 * n; i++) {
            v.computeIfAbsent(A[i], k -> new ArrayList<>()).add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> listA = v.get(a);
            List<Integer> listB = v.get(b);

            int minn = Integer.MAX_VALUE;

            for (int i = 0; i < listA.size(); i++) {
                int target = listA.get(i);
                int l = 0, h = listB.size();

                // Upper-bound binary search
                while (l < h) {
                    int mid = l + (h - l) / 2;
                    if (listB.get(mid) <= target) {
                        l = mid + 1;
                    } else {
                        h = mid;
                    }
                }

                if (h < listB.size()) {
                    minn = Math.min(minn, Math.abs(listB.get(h) - target));
                }
                if (h != 0) {
                    minn = Math.min(minn, Math.abs(target - listB.get(h - 1)));
                }
            }

            sb.append(minn / 2).append("\n");
        }

        System.out.print(sb);
    }
}
