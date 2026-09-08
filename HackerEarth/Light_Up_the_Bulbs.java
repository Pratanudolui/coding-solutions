import java.io.*;
import java.util.*;

public class Test {
    
    // Class to represent a 2D Point/Bulb coordinate
    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        // Calculates square of the Euclidean distance between two points
        long distanceSq(Point other) {
            long dx = this.x - other.x;
            long dy = this.y - other.y;
            return dx * dx + dy * dy;
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast I/O setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (!st.hasMoreTokens()) return;
        int n = Integer.parseInt(st.nextToken());

        Point[] bulbs = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            bulbs[i] = new Point(x, y);
        }

        // Prim's algorithm implementation for complete graph O(N^2)
        boolean[] visited = new boolean[n];
        long[] minEdge = new long[n];
        
        // Initialize minimum distance array with infinity
        for (int i = 0; i < n; i++) {
            minEdge[i] = Long.MAX_VALUE;
        }
        
        // Start from node 0
        minEdge[0] = 0;
        long totalMstWeight = 0;

        for (int step = 0; step < n; step++) {
            int u = -1;
            long minVal = Long.MAX_VALUE;

            // Pick the unvisited node with the minimum connecting edge
            for (int i = 0; i < n; i++) {
                if (!visited[i] && minEdge[i] < minVal) {
                    minVal = minEdge[i];
                    u = i;
                }
            }

            // Add selected node to MST
            visited[u] = true;
            totalMstWeight += minVal;

            // Update minimum edge weights to remaining unvisited nodes
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    long dist = bulbs[u].distanceSq(bulbs[v]);
                    if (dist < minEdge[v]) {
                        minEdge[v] = dist;
                    }
                }
            }
        }

        System.out.println(totalMstWeight);
    }
}
