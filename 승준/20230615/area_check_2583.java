import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class area_check_2583 {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int rectangleCount = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        for (int[] row : arr) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < rectangleCount; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            drawRectangle(sx, sy, ex, ey);
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    areas.add(dfs(j, i));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }
    public static void drawRectangle(int sx, int sy, int ex, int ey) {
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                arr[i][j] = 1;
            }
        }
    }
    public static int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || arr[y][x] != 0) {
            return 0;
        }

        arr[y][x] = 1;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            count += dfs(nx, ny);
        }

        return count;
    }
}
