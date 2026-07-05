import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void computeFreq(List<List<Integer>> market, int[][] freq) {
        int marketSize = market.size();
        for (int i = 0; i < marketSize; i++) {
            int companies = market.get(i).size();
            if (companies > 2) {
                for (int j = 0; j < companies - 1; j++) {
                    for (int k = j + 1; k < companies; k++) {
                        freq[Math.min(market.get(i).get(j), market.get(i).get(k))]
                                [Math.max(market.get(i).get(j), market.get(i).get(k))]++;
                    }
                }
            }
        }
    }

    static int minimumMergers(List<List<Integer>> companyDetails, int n, int m, int marketCount) {
        int ans = 0, i, j, k;
        List<List<Integer>> market = new ArrayList<>(marketCount);
        for (i = 0; i < marketCount; i++) {
            market.add(new ArrayList<>());
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                market.get(companyDetails.get(i).get(j)).add(i);
            }
        }

        int marketSize = market.size(), companies;
        for (i = 0; i < marketSize; i++) {
            companies = market.get(i).size();
            while (companies > 2) {
                int[][] freq = new int[5][5];
                computeFreq(market, freq);
                int maxm = -1, p = 0, q = 0, x, y;
                for (j = 0; j < companies - 1; j++) {
                    for (k = j + 1; k < companies; k++) {
                        x = Math.min(market.get(i).get(j), market.get(i).get(k));
                        y = Math.max(market.get(i).get(j), market.get(i).get(k));
                        if (freq[x][y] > maxm) {
                            maxm = freq[x][y];
                            p = x;
                            q = y;
                        }
                    }
                }
                market.get(i).remove((Integer) q);
                for (j = i + 1; j < marketSize; j++) {
                    List<Integer> marketJ = market.get(j);
                    int idx = marketJ.indexOf(q);
                    if (idx != -1) {
                        marketJ.remove(idx);
                        if (!marketJ.contains(p)) {
                            marketJ.add(p);
                        }
                    }
                }
                companies--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> companyDetails = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> v = new ArrayList<>();
            long r;
            for (int j = 0; j < m; j++) {
                r = scanner.nextLong();
                int marketCount = ids.indexOf(r);
                if (marketCount == -1) {
                    marketCount = ids.size();
                    ids.add(r);
                }
                v.add(marketCount);
            }
            companyDetails.add(v);
        }

        System.out.println(minimumMergers(companyDetails, n, m, ids.size()));
    }
}
