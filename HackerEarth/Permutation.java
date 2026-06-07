import java.util.*;

public class Main {
    static String encode(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int x : a) sb.append(x);
        return sb.toString();
    }

    static int[] decode(String s) {
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] start = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        String startKey = encode(start);

        StringBuilder targetBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) targetBuilder.append(i);
        String target = targetBuilder.toString();

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        q.offer(startKey);
        dist.put(startKey, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.equals(target)) {
                System.out.println(dist.get(cur));
                return;
            }

            int[] arr = decode(cur);

            for (int len = 2; len <= n; len++) {
                int[] next = arr.clone();

                for (int l = 0, r = len - 1; l < r; l++, r--) {
                    int temp = next[l];
                    next[l] = next[r];
                    next[r] = temp;
                }

                String key = encode(next);

                if (!dist.containsKey(key)) {
                    dist.put(key, dist.get(cur) + 1);
                    q.offer(key);
                }
            }
        }
    }
}
