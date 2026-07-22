class Solution {

    public int makeConnected(int n, int[][] connections) {

        // To connect n computers, we need at least (n - 1) cables.
        // If we have fewer cables than that, it is impossible.
        if (connections.length < n - 1) {
            return -1;
        }

        // Create adjacency list for the graph.
        List<Integer>[] graph = new ArrayList[n];

        // Initialize each list.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the undirected graph.
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // Track visited computers.
        boolean[] visited = new boolean[n];

        // Count connected components.
        int components = 0;

        // Traverse every computer.
        for (int i = 0; i < n; i++) {

            // If not visited, we found a new component.
            if (!visited[i]) {
                components++;

                // Visit all computers in this component.
                dfs(i, graph, visited);
            }
        }

        // If there are k components,
        // we need (k - 1) cables to connect them.
        return components - 1;
    }

    // DFS to visit all nodes in one component.
    private void dfs(int node,
                     List<Integer>[] graph,
                     boolean[] visited) {

        // Mark current node as visited.
        visited[node] = true;

        // Visit all neighbors.
        for (int neighbor : graph[node]) {

            // Visit only unvisited neighbors.
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}