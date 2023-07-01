import java.io.*;
import java.util.*;

public class tree_1068 {
    private static void dfs(int num, int[] parent) {
        parent[num] = -2;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == num){
                dfs(i, parent);
            }
        }
    }

    private static boolean contains(int[] parent, int num){
        for (int n : parent) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] parent = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < parent.length; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int delete = Integer.parseInt(st.nextToken());

        dfs(delete, parent);
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -2 && !contains(parent, i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
