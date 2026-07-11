class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] nodeCount = new int[n];
        int[] edgeCount = new int[n];
        
        // Initialize each node to be its own parent, with 1 node and 0 edges
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            nodeCount[i] = 1;
        }
        
        // Union find tracking
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int rootU = find(u, parent);
            int rootV = find(v, parent);
            
            if (rootU != rootV) {
                // Merge group V into group U
                parent[rootV] = rootU;
                nodeCount[rootU] += nodeCount[rootV];
                edgeCount[rootU] += edgeCount[rootV] + 1; // Add this new connecting edge
            } else {
                // u and v are already in the same group; this is a redundant edge within it
                edgeCount[rootU]++;
            }
        }
        
        int completeComponents = 0;
        
        // Check the roots of all components
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) { // This node is the leader of its component
                int nodes = nodeCount[i];
                int totalEdges = edgeCount[i];
                
                // Since DSU processes edges once, no double counting occurs.
                // Formula: E == V * (V - 1) / 2
                if (totalEdges == (nodes * (nodes - 1)) / 2) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }
    
    // Find with path compression
    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
}
