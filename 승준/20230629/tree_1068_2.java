import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int value;
    List<Node> children;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class Tree {
    private Node[] nodes;
    private int count;

    public Tree(int[] parent, int deleteNode) {
        int n = parent.length;
        this.nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            int parentNode = parent[i];
            if (parentNode != -1) {
                nodes[parentNode].children.add(nodes[i]);
            }
        }

        remove(nodes[deleteNode]);
    }

    public void remove(Node node) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            remove(child);
        }

        node.children.clear();
    }

    public int countLeafNodes() {
        count = 0;
        countLeaf(nodes[0]);
        return count;
    }

    private void countLeaf(Node node) {
        if (node == null) {
            return;
        }

        if (node.children.isEmpty()) {
            count++;
        }

        for (Node child : node.children) {
            if (child.children.isEmpty()) { // 자식 노드가 없으면 리프 노드로 카운트
                count++;
            }
        }
    }
}

public class tree_1068_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        int deleteNode = Integer.parseInt(br.readLine());

        Tree tree = new Tree(parent, deleteNode);
        int leafCount = tree.countLeafNodes();
        System.out.println(leafCount);
    }
}
