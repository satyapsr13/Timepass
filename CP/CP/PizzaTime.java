import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class PizzaTime {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    static int getMinFromArr(int[] arr) {
        int max = Integer.MAX_VALUE;
        for (int num : arr)
            if (num < max)
                max = num;
        return max;
    }

    public static ArrayList<Integer> getPrimeFactors(ArrayList<Integer> primes, int target) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int prime : primes) {
            if (prime * prime > target)
                break; // optimization: stop if prime^2 > target
            while (target % prime == 0) {
                factors.add(prime);
                target /= prime;
            }
        }

        // if remaining target is > 1, it itself is a prime factor
        if (target > 1)
            factors.add(target);

        return factors;
    }

    static ArrayList<Integer> getAllPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }

    static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) { // avoid adding sqrt twice
                    factors.add(n / i);
                }
            }
        }

        Collections.sort(factors);
        return factors;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) // early stop if GCD becomes 1
                return 1;
        }
        return result;
    }

    static void solve() {
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = sc.nextArray(n);
        int ans = 1;
        int mn = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);

        TreeSet<Integer> divs = new TreeSet<>(Collections.reverseOrder());
        for (int x : arr) {
            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    divs.add(d);
                    divs.add(x / d);
                }
            }
        }
        for (int d : divs) {
            int erasures = 0;
            for (int x : arr) {
                if ((x % 3 == 0) && ((x / 3) % d == 0)) {

                } else if (x % d != 0 && x < 2 * d) {
                    erasures++;
                }
            }
            if (erasures <= q) {
                ans = d;
                break; // Since divisors are in descending order
            }
        }

        out.println(ans);

        // your logic here
        // out.println("Your answer");
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
