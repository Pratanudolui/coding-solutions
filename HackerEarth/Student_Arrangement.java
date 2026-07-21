import java.util.*;

public class Main {
    public static void printFrequency(List<Long> vec, long k, long m, long n) {
        TreeMap<Long, Long> map = new TreeMap<>();

        for (long i = 1; i <= m; i++) {
            map.put(i, 0L); // initialize all rows with 0 count
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (map.size() == 0) {
                ans += (n - i); // all rows are full
                break;
            }

            long val = vec.get(i);
            Long key = map.ceilingKey(val); // like lower_bound

            if (key == null) {
                key = map.firstKey(); // wrap around to first key
            }

            if (!key.equals(val)) {
                ans++; // mismatch from desired row
            }

            // update count
            map.put(key, map.get(key) + 1);

            // remove row if full
            if (map.get(key).equals(k)) {
                map.remove(key);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        List<Long> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(sc.nextLong());
        }

        printFrequency(v, k, m, n);
    }
}
