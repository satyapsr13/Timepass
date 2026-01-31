import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class Solution {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean isExist(String s, int i, int n) {
        if (i == 0 || i > n - 3)
            return false;
        return (s.charAt(i) == '0') && (s.charAt(i - 1) == '0') && (s.charAt(i + 1) == '0') && (s.charAt(i + 2) == '0');
    }

    static int count(StringBuilder s) {
        int sum = 0;
        for (char ch : s.toString().toCharArray()) {
            if (ch == '1')
                sum++;
        }
        return sum;
    }

    static void modify(StringBuilder sb, int i, int n) {
        // for(int i)

    }

    // Count occurrences of a particular character
    public static int countChar(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                count++;
        }
        return count;
    }

    static void solve() {
        int n = sc.nextInt();
        String s = sc.next();
        if (n <= 2) {
            if (n == 1) {
                System.out.println("1");
                return;
            } else if (n == 2) {
                System.out.println(Math.max(1, count(new StringBuilder(s))));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(s);

        if (sb.charAt(0) == '0' && sb.charAt(1) == '0') {
            sb.setCharAt(1, '1');
        }
        int sum = 0;
        
        for (int i = 0; i < n; ++i) {
            if (sb.charAt(i) == '0') {
                sum++;

            } else {
                sum = 0;
            }
            if (sum == 3) {
                sum = 0;
                sb.setCharAt(i, '1');
            }
        }
        if (sb.charAt(n-2) == '0' && sb.charAt(n-1) == '0') {
            sb.setCharAt(n-1, '1');
        }
        System.out.println(countChar(sb.toString(), '1'));
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0)
            solve();
        out.flush();
    }

    // --- Utility Classes/Methods Below ---
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        String[] nextStringArray(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++)
                arr[i] = next();
            return arr;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static void printArr(Object arr) {
        int len = Array.getLength(arr);
        for (int i = 0; i < len; i++) {
            if (i > 0)
                out.print(" ");
            out.print(Array.get(arr, i));
        }
        out.println();
    }
}
