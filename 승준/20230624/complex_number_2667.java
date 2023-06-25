import java.io.*;
import java.util.*;

public class complex_number_2667 {
    static int n;
    static int[][] graph;
    static int number;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        number = 1;
        count = 0;
        queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        int[] countArr = new int[n * n];
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    number++;
                    count = bfs(number, i, j);
                    countArr[islandCount++] = count;
                }
            }
        }

        System.out.println(number-1);
        int[] nonZeroCountArr = Arrays.stream(countArr).filter(x -> x != 0).toArray();
        Arrays.sort(nonZeroCountArr);
        for (int i = 0; i < islandCount; i++) {
            System.out.println(nonZeroCountArr[i]);
        }
    }

    static int bfs(int number, int sy, int sx) {
        queue.clear();
        queue.add(new int[]{sy, sx});
        graph[sy][sx] = number;
        count = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if ( 0 <= ny && ny < n && 0 <= nx && nx < n && graph[ny][nx] == 1) {
                    queue.add(new int[]{ny, nx});
                    graph[ny][nx] = number;
                    count++;
                }
            }
        }
        return count;
    }
}
