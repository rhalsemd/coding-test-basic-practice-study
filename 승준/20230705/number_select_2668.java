import java.io.*;
import java.util.*;

public class number_select_2668 {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n+1];
        numbers[0] = 0;
        for (int i = 1; i < n+1; i++){
           numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 1; j < n+1; j++){
            boolean[] visited = new boolean[n+1];
            Arrays.fill(visited, false);
            dfs(numbers, visited, j, j);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void dfs(int[] graph, boolean[] visited, int start, int current){
        visited[current] = true;
        int next = graph[current];

        if (!visited[next]) {
            dfs(graph, visited, start, next);
        } else if (start == next) {
            result.add(start);
        }
    }
}
