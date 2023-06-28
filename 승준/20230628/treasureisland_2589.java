import java.io.*;
import java.util.*;

public class treasureisland_2589 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max_dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // L : 1, W : 0
        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char c = line.charAt(j);
                if (c == 'L') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    int dist = bfs(i, j, arr, row, col);
                    if (max_dist < dist) {
                        max_dist = dist;
                    }
                }
            }
        }

        System.out.println(max_dist);
    }

    public static int bfs(int sy, int sx, int[][] arr, int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy, sx});

        int[][] distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(distance[i], -1);
        }

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], false);
        }

        visited[sy][sx] = true;
        distance[sy][sx] = 0;
        int max_distance = 0;
        while (!queue.isEmpty()) {
            int[] queue_yx = queue.poll();
            int y = queue_yx[0];
            int x = queue_yx[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if ( 0 <= ny && ny < row && 0 <= nx && nx < col && visited[ny][nx] == false && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    distance[ny][nx] = distance[y][x] + 1;
                    if (distance[ny][nx] > max_distance) {
                        max_distance = distance[ny][nx];
                    }
                }
            }
        }

        return max_distance;
    }
}
