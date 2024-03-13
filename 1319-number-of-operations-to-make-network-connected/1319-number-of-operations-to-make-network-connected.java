class Solution {
    private int[] parents;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        parents = new int[n];
        for (int idx = 0; idx < n; idx++) {
            parents[idx] = idx;
        }

        for (var conn: connections) {
            var node1 = conn[0];
            var node2 = conn[1];
            union(node1, node2);
        }

        HashSet<Integer> parentSet = new HashSet<>();
        for (var parent: parents) {
            parentSet.add(find(parent));
        }

        return parentSet.size() - 1;
    }

    private int find(int node) {
        if (node == parents[node]) {
            return node;
        }
        parents[node] = find(parents[node]);
        return parents[node];
    }

    private void union(int node1, int node2) {
        parents[find(node1)] = find(node2);
    }
}