import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) lines.add(line.trim());
        }

        int i = 1;

        while (i < lines.size()) {
            int n = Integer.parseInt(lines.get(i++));

            StringTokenizer st = new StringTokenizer(lines.get(i++));
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int res = 1;

            for (int j = 0; j < n; j++) {
                if (arr[j] >= res * 2) {
                    res++;
                }
            }

            System.out.println(2 * res);
        }
    }
}
