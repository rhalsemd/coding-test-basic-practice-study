import java.io.*;
import java.util.*;
class Node {
    int value;
    List<Node> children;

    public Node(int value){
        this.value = value;
        this.children = new ArrayList<>();
    }
}
public class tree_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1){
                nodes[parent].children.add(nodes[i]);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());

        remove(nodes[removeNode]);

        int leafCount = countLeafNodes(nodes[0]);
        if (nodes[removeNode] != null) leafCount--;
        System.out.println(leafCount);
    }

    public static void remove(Node node){
        if (node == null){
            return;
        }

        for(Node child : node.children) {
            remove(child);
        }

        node.children.clear();
    }

    public static int countLeafNodes(Node node){
        if (node == null) {
            return 0;
        }

        if (node.children.isEmpty()) {
            return 1;
        }

        int count = 0;
        for (Node child : node.children) {
            count += countLeafNodes(child);
        }

        return count;
    }
}
