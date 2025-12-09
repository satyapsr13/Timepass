import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class E2156 {
    // author: satyapsr13
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    // Floor division (round down)
    public static int fdiv(int num, int denom) {
        return num / denom - ((num ^ denom) < 0 && num % denom != 0 ? 1 : 0);
    }

    // Ceil division (round up)
    public static int cdiv(int num, int denom) {
        return fdiv(num + denom - 1, denom);
    }

    static boolean isContains(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] - nums[i] >= target) {
                    count++;
                    if (count >= 2) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    static void solve() {
        int n = sc.nextInt();
        int[] arr = sc.nextArray(n);

        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        int ans = -1;
        while (l < r) {
            int mid = cdiv(l + r, 2);

            if (isContains(arr, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        System.out.println(ans);

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
