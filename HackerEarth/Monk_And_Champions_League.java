import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Math.max(1, m), Collections.reverseOrder());

        int readCount = 0;
        while (readCount < m) {
            String rowLine = br.readLine();
            if (rowLine == null) break;
            StringTokenizer rowSt = new StringTokenizer(rowLine);
            while (rowSt.hasMoreTokens() && readCount < m) {
                int seats = Integer.parseInt(rowSt.nextToken());
                if (seats > 0) {
                    maxHeap.offer(seats);
                }
                readCount++;
            }
        }

        long totalRevenue = 0L;
        for (int i = 0; i < n && !maxHeap.isEmpty(); i++) {
            int maxSeats = maxHeap.poll();
            totalRevenue += maxSeats;
            if (maxSeats - 1 > 0) {
                maxHeap.offer(maxSeats - 1);
            }
        }

        System.out.println(totalRevenue);
    }
}
