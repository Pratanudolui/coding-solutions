import java.io.*;
import java.util.*;

public class Main {

    static void rotate(int[] curr) {
        int temp = curr[0];
        curr[0] = curr[1];
        curr[1] = temp;
    }

    static void switchPlayer(int[] curr) {
        curr[0] = Math.max(curr[0], curr[1]) + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            String arr = br.readLine();

            int overBall = 0;

            int[] score = new int[p + 2];
            boolean[] out = new boolean[p + 2];
            boolean[] played = new boolean[p + 2];

            int[] curr = {1, 2};
            played[1] = true;
            if (p >= 2) played[2] = true;

            for (int i = 0; i < arr.length(); i++) {
                char ch = arr.charAt(i);
                overBall++;

                if (ch == '0') {
                    // nothing
                } else if (ch == '1') {
                    score[curr[0]] += 1;
                    rotate(curr);
                } else if (ch == '2') {
                    score[curr[0]] += 2;
                } else if (ch == '4') {
                    score[curr[0]] += 4;
                } else if (ch == '6') {
                    score[curr[0]] += 6;
                } else if (ch == 'W') {
                    out[curr[0]] = true;
                    switchPlayer(curr);
                    if (curr[0] <= p) played[curr[0]] = true;
                }

                if (overBall == 6) {
                    rotate(curr);
                    overBall = 0;
                }
            }

            System.out.println("Case " + tc + ":");

            int maxPlayer = Math.max(curr[0], curr[1]);

            if (maxPlayer == 2) {
                for (int i = 1; i <= Math.min(2, p); i++) {
                    System.out.println("Player " + i + ": " + score[i] + "*");
                }
            } else {
                for (int i = 1; i <= Math.min(maxPlayer, p); i++) {
                    if (out[i]) {
                        System.out.println("Player " + i + ": " + score[i]);
                    } else {
                        System.out.println("Player " + i + ": " + score[i] + "*");
                    }
                }
            }

            for (int i = maxPlayer + 1; i <= p; i++) {
                System.out.println("Player " + i + ": DNB");
            }
        }
    }
}
