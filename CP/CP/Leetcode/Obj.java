import java.util.Arrays;
import java.util.Objects;
import java.util.*;

class MinStack {
    ArrayDeque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();

    }

    public class Obj {
        class Edge implements Comparable<Edge> {
            public int x, y;

            @Override
            public int compareTo(Edge other) {
                return Integer.compare(this.x, other.x);
            }

            @Override
            public boolean equals(Object other) {
                if (!(other instanceof Edge))
                    return false;

                Edge temp = (Edge) other;

                return temp.x == this.x;
            }

            @Override
            public int hashCode() {
                // return Objects.hash(x, y);
                return Arrays.hashCode(new int[] { x, y });
            }

        }
    }

}
