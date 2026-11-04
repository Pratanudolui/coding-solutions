import java.io.*;
import java.util.*;

public class TestClass {
    static class State implements Comparable<State> {
        long sum;
        int i, j, k;

        public State(long sum, int i, int j, int k) {
            this.sum = sum;
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public int compareTo(State other) {
            // Max-heap based on sum
            return Long.compare(other.sum, this.sum);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            int kCount = Integer.parseInt(br.readLine().trim());

            Long[] b1 = readAndSortDescending(br, x);
            Long[] b2 = readAndSortDescending(br, y);
            Long[] b3 = readAndSortDescending(br, z);

            PriorityQueue<State> pq = new PriorityQueue<>();
            Set<String> visited = new HashSet<>();

            pq.add(new State(b1[0] + b2[0] + b3[0], 0, 0, 0));
            visited.add("0,0,0");

            long totalSum = 0;
            for (int step = 0; step < kCount; step++) {
                State curr = pq.poll();
                totalSum += curr.sum;

                int i = curr.i;
                int j = curr.j;
                int k = curr.k;

                // Try next state in B1
                if (i + 1 < x) {
                    String key = (i + 1) + "," + j + "," + k;
                    if (visited.add(key)) {
                        pq.add(new State(b1[i + 1] + b2[j] + b3[k], i + 1, j, k));
                    }
                }

                // Try next state in B2
                if (j + 1 < y) {
                    String key = i + "," + (j + 1) + "," + k;
                    if (visited.add(key)) {
                        pq.add(new State(b1[i] + b2[j + 1] + b3[k], i, j + 1, k));
                    }
                }

                // Try next state in B3
                if (k + 1 < z) {
                    String key = i + "," + j + "," + (k + 1);
                    if (visited.add(key)) {
                        pq.add(new State(b1[i] + b2[j] + b3[k + 1], i, j, k + 1));
                    }
                }
            }

            sb.append(totalSum).append("\n");
        }

        System.out.print(sb);
    }

    private static Long[] readAndSortDescending(BufferedReader br, int size) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }
}
