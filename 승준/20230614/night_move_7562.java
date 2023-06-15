import java.awt.*;
import java.io.*;
import java.util.*;

public class night_move_7562 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++){
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            // 최소 움직여서 타겟지점으로 가는 함수
            int minMoves = getMinMoves(len, cx, cy, tx, ty);
            System.out.println(minMoves);
        }
    }

    public static int getMinMoves(int len, int cx, int cy, int tx, int ty) {
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        boolean[][] visited = new boolean[len][len];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(cx, cy));
        visited[cx][cy] = true;

        int minMoves = 0;
        boolean foundTarget = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point c = queue.poll();

                if (c.x == tx && c.y == ty) {
                    foundTarget = true;
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = c.x + dx[j];
                    int ny = c.y + dy[j];

                    if (nx >= 0 && nx < len && ny >= 0 && ny < len && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }

            if (foundTarget) {
                break;
            }

            minMoves++;
        }

        return minMoves;
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
