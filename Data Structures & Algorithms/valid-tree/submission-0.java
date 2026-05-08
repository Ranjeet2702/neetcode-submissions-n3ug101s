

class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        // Rule 1: valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS to check connectivity
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}