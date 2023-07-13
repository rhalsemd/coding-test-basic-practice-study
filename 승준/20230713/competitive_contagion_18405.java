import java.io.*;
import java.util.*;
public class competitive_contagion_18405 {
    static class Block {
        int value;
        int y;
        int x;
        int sec;

        Block(int value, int y, int x, int sec) {
            this.value = value;
            this.y = y;
            this.x = x;
            this.sec = sec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] blocks = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                blocks[i][j] = value;
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][N];

        List<Block> queue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] != 0) {
                    queue.add(new Block(blocks[i][j], i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        Collections.sort(queue, new Comparator<Block>() {
            @Override
            public int compare(Block b1, Block b2) {
                return b1.value - b2.value;
            }
        });

        int result = bfs(blocks, visited, queue, N, S, X, Y);
        System.out.println(result);
    }

    public static int bfs(int[][] blocks, boolean[][] visited, List<Block> queue, int N, int S, int X, int Y) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Block block = queue.remove(0);
            int value = block.value;
            int y = block.y;
            int x = block.x;
            int sec = block.sec;

            if (sec == S) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && blocks[ny][nx] == 0) {
                    blocks[ny][nx] = value;
                    visited[ny][nx] = true;
                    queue.add(new Block(value, ny, nx, sec + 1));
                }
            }
        }

        return blocks[X-1][Y-1];
    }
}
