import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TestClass {

    static class Topic implements Comparable<Topic> {
        long id;
        long initialZ;
        long finalZ;
        long diff;

        public Topic(long id, long initialZ, long finalZ, long diff) {
            this.id = id;
            this.initialZ = initialZ;
            this.finalZ = finalZ;
            this.diff = diff;
        }

        @Override
        public int compareTo(Topic other) {
            // Min-heap based on change in z-score (diff), then by ID
            if (this.diff != other.diff) {
                return Long.compare(this.diff, other.diff);
            }
            return Long.compare(this.id, other.id);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        
        // Priority Queue to keep the top 5 elements (Min-Heap by default)
        PriorityQueue<Topic> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) break;
            
            StringTokenizer st = new StringTokenizer(line);
            long id = Long.parseLong(st.nextToken());
            long z = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            long finalZ = p * 50 + l * 5 + c * 10 + s * 20;
            long diff = finalZ - z;

            Topic topic = new Topic(id, z, finalZ, diff);
            pq.offer(topic);

            // Keep only top 5 elements in the heap
            if (pq.size() > 5) {
                pq.poll();
            }
        }

        // Extract elements from heap into an array to print them in descending order of priority
        Topic[] topTopics = new Topic[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--) {
            topTopics[i] = pq.poll();
        }

        StringBuilder sb = new StringBuilder();
        for (Topic t : topTopics) {
            sb.append(t.id).append(" ").append(t.finalZ).append("\n");
        }
        System.out.print(sb);
    }
}
