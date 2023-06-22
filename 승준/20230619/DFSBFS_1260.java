import java.io.*;
import java.util.*;

public class DFSBFS_1260 {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 정점 갯수,  m: 간선 갯수, v: 시작 정점
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n + 1];

        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];

        bfs(v);
        System.out.println();

    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
