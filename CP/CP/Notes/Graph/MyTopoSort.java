import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class MyTopoSort {
    private static List<Integer> topoSort(int n, List<List<Integer>> graph) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                q.offer(i);

            }

        }

        List<Integer> toposort = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            toposort.add(node);
            for (int neighbor : graph.get(node)) {
                if (--indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }

        }
        if (toposort.size() != n)
            throw new RuntimeException("Graph contains cycle");

        return toposort;

    }

    public static void main(String[] args) {

    }
}
