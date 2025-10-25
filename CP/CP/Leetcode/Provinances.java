import java.util.ArrayList;

class Solution {
    private ArrayList<ArrayList<Integer>> buildGraph(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(m));
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isConnected[i][j] == 1)
                    graph.get(i).add(j);

            }
        }
        return graph;
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(isConnected);
        int ans = 0;
        boolean[] 
        return ans;
    }
}

public class Provinances {

}
