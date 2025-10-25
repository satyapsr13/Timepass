import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class DfsImpl {
    class Solution {

        class Cell {
            public int x, y, time;

            public Cell(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.time = val;

            }
        }
        public static void debugDp(int[][] dp) {
            System.out.println("DP Table:");
            for (int i = 0; i < dp.length; i++) {
                System.out.print("Row " + i + ": ");
                for (int j = 0; j < dp[i].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------");
        }
        

        public boolean isInside(int x, int y, int n, int m) {
            return x >= 0 && x < n && y >= 0 && y < m;
        }

        public int orangesRotting(int[][] grid) {
            int ans = 0;

            Deque<Cell> q = new ArrayDeque<>();

            int n = grid.length;
            int m = grid[0].length;
            boolean[][] vis = new boolean[n][m];
            for (int i = 0; i < n; ++i) {

                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 2) {
                        q.offer(new Cell(i, j, 0));
                        vis[i][j] = true;

                    }
                }
            }
            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };

            while (!q.isEmpty()) {
                Cell front = q.poll();
                ans = Math.min(ans, front.time);

                for (int i = 0; i < 4; ++i) {
                    int newX = front.x + dx[i];
                    int newY = front.y + dy[i];
                    if (isInside(newX, newY, n, m) && !vis[newX][newY] && grid[newX][newY] == 1) {
                        q.offer(new Cell(newX, newY, front.time + 1));
                        vis[newX][newY] = true;
                        grid[newX][newY] = 2;
                    }

                }
            }
            for (int i = 0; i < n; ++i) {

                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }

                }
            }

            return ans;
        }
    }
}
