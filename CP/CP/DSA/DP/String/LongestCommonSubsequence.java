package DSA.DP.String;

import java.util.Scanner;

public class LongestCommonSubsequence {
    private static int getLCSLength(String s1, String s2, boolean printLcs) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                }

            }
        }

        if (printLcs

        ) {
            int i = n, j = m;
            StringBuilder ans = new StringBuilder();

            while (i > 0 && j > 0) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    ans.append(s1.charAt(i-1));
                    i--;
                    j--;
                } else {
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        j--;
                    } else {
                        i--;

                    }

                }

            }
            System.out.println(ans.reverse().toString());
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Longest common subsequence:");
        System.out.println(getLCSLength(sc.next(), sc.next(), true));
    }
}
