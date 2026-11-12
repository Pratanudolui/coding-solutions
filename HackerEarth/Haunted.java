import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] days = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Integer> freqMap = new HashMap<>();
        // TreeMap to group ghost ages by their frequency count, keeping ages sorted
        TreeMap<Integer, TreeSet<Long>> countToAges = new TreeMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long ghostAge = days[i];
            
            // Remove ghost from old frequency set if it exists
            int oldFreq = freqMap.getOrDefault(ghostAge, 0);
            if (oldFreq > 0) {
                countToAges.get(oldFreq).remove(ghostAge);
                if (countToAges.get(oldFreq).isEmpty()) {
                    countToAges.remove(oldFreq);
                }
            }

            int newFreq = oldFreq + 1;
            freqMap.put(ghostAge, newFreq);
            
            countToAges.putIfAbsent(newFreq, new TreeSet<>());
            countToAges.get(newFreq).add(ghostAge);

            // The highest frequency is the last key in the TreeMap
            int maxFreq = countToAges.lastKey();
            // The oldest ghost among those with maxFreq is the last element in the TreeSet
            long bestGhost = countToAges.get(maxFreq).last();

            sb.append(bestGhost).append(" ").append(maxFreq).append("\n");
        }

        System.out.print(sb);
    }
}
