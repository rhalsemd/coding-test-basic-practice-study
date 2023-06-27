import java.io.*;
import java.util.*;

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
public class binary_search_tree_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> preorder = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            int node = Integer.parseInt(input);
            preorder.add(node);
        }

        List<Integer> postorder = getPostorder(preorder);
        for (int n : postorder) {
            System.out.println(n);
        }
    }

    public static List<Integer> getPostorder(List<Integer> preorder) {
        if (preorder.size() <= 1) {
            return preorder;
        }

        Stack<Pair<List<Integer>, Boolean>> stack = new Stack<>();
        List<Integer> postorder = new ArrayList<>();
        stack.push(new Pair<>(preorder, false));

        while (!stack.isEmpty()) {
            Pair<List<Integer>, Boolean> pair = stack.pop();
            List<Integer> nodes = pair.getKey();
            boolean visited = pair.getValue();

            if (visited) {
                postorder.add(nodes.get(0));
            } else {
                int root = nodes.get(0);
                List<Integer> left = new ArrayList<>();
                List<Integer> right = new ArrayList<>();

                for (int i = 1; i < nodes.size(); i++) {
                    int node = nodes.get(i);
                    if (node < root) {
                        left.add(node);
                    } else if (node > root) {
                        right.add(node);
                    }
                }

                stack.push(new Pair<>(nodes, true));
                if (!right.isEmpty()) {
                    stack.push(new Pair<>(right, false));
                }
                if (!left.isEmpty()) {
                    stack.push(new Pair<>(left, false));
                }
            }
        }

        return postorder;
    }
}