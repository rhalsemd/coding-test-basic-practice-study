import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class maze_search_2178 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n : 세로, m : 가로
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++){
                // char => string => int
                maze[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        // 방문처리
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = -1;
            }
        }

        // 큐 => 시작 지점 넣고 => 시작 지점 0으로 방문 처리
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[ny][nx] == 1 && dist[ny][nx] == -1) {
                    queue.offer(new int[]{ny, nx});
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }

        System.out.println(dist[n-1][m-1]);
    }
}
