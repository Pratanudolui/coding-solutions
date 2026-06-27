import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String tweet = br.readLine();
            String[] words = tweet.split(" ");

            for (String word : words) {
                if (word.length() > 0 && word.charAt(0) == '#') {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // Higher frequency first
            }
            return a.getKey().compareTo(b.getKey()); // Lexicographical order
        });

        int limit = Math.min(5, list.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(list.get(i).getKey());
        }
    }
}
