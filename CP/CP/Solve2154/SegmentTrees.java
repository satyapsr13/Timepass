import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.util.*;

public class SegmentTrees {

    static void buildSegmentTree() {

    }

    static void debug(Object... values) {
        for (Object val : values) {
            System.out.println(val.toString());
        }
    }

    static void buildSeg(int[] tree, int idx, int[] arr, int n, int l, int r) {
        if (l >= r) {
            tree[idx] = arr[l];

        } else {
            int mid = l + (r - l) / 2;
            buildSeg(tree, 2 * idx + 1, arr, n, l, mid);
            buildSeg(tree, 2 * idx + 2, arr, n, mid + 1, r);
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 1];
        }
    }

    static void debugArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;

        int[] tree = new int[n * 4];
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (int) (10 * Math.random()) + 50;

        }
        debugArr(arr);
        buildSeg(tree, 0, arr, n, 0, n - 1);
        debugArr(tree);
    }
}
