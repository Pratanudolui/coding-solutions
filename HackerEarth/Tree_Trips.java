import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    // Representation of a tree edge
    static class Edge {
        int u, v, id;
        
        Edge(int u, int v, int id) {
            this.u = u;
            this.v = v;
            this.id = id;
        }
    }

    // Representation of a trip request
    static class Trip {
        int start, end;
        
        Trip(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast I/O for input processing
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        List<List<Edge>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read N - 1 tree edges
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(u, v, i);
            edges.add(edge);
            adj.get(u).add(edge);
            adj.get(v).add(edge);
        }

        // Read M trips
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trips.add(new Trip(x, y));
        }

        // Store the set of edges used along the path for each trip
        List<Integer> tripEdgeMasks = new ArrayList<>();
        for (Trip trip : trips) {
            int mask = findPathMask(trip.start, trip.end, -1, adj, 0);
            tripEdgeMasks.add(mask);
        }

        int minRemovedEdges = n - 1;
        int numEdges = n - 1;

        // Iterate through all possible subsets of edges to remove (2^(N-1) bitmasks)
        for (int mask = 0; mask < (1 << numEdges); mask++) {
            boolean blocksAllTrips = true;

            // Check if every trip has at least one removed edge on its path
            for (int pathMask : tripEdgeMasks) {
                if ((mask & pathMask) == 0) {
                    blocksAllTrips = false; // Path is still intact; trip is possible
                    break;
                }
            }

            // If all trips are blocked, track the minimum edges removed
            if (blocksAllTrips) {
                minRemovedEdges = Math.min(minRemovedEdges, Integer.bitCount(mask));
            }
        }

        System.out.println(minRemovedEdges);
    }

    // Depth First Search to find which edges form the simple path from 'curr' to 'target'
    private static int findPathMask(int curr, int target, int parent, List<List<Edge>> adj, int currentMask) {
        if (curr == target) {
            return currentMask;
        }

        for (Edge edge : adj.get(curr)) {
            int nextNode = (edge.u == curr) ? edge.v : edge.u;
            if (nextNode != parent) {
                int resultMask = findPathMask(nextNode, target, curr, adj, currentMask | (1 << edge.id));
                if (resultMask != -1) {
                    return resultMask; // Target found on this branch
                }
            }
        }

        return -1; // Target not reachable on this path
    }
}
