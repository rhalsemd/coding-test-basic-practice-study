import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x, y, len;

        public Pair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    static char[][] map;
    static boolean[][] visited;
    static int N, M, answer;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        answer = 0;

        for(int i = 0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j<M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[N][M]; 
                    bfs(new Pair(i, j, 0));
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(Pair p) {
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;

        while(!q.isEmpty()) {
            Pair nextP = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = nextP.x + dx[k];
                int ny = nextP.y + dy[k];

                if(valid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, nextP.len + 1));
                    answer = Math.max(answer, nextP.len + 1);
                }
            }
        }
    }

    static boolean valid(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }
}