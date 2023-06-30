import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int ans = 2000;
        boolean[][] visit = new boolean[N + 1][N + 1];
        visit[1][0] = true;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {1,0,0});

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            if (z >= ans) {
                continue;
            }
            if (x == N) {
                ans = Math.min(ans, z);
            }else{
                if (!visit[x][x]){
                    que.add(new int[] {x, x, z+1});
                    visit[x][x] = true;
                }
                if (y>0 && x+y <=N && !visit[x+y][y]){
                    que.add(new int[] {x+y, y, z+1});
                    visit[x+y][y] = true;
                }
                if (x>1 && !visit[x-1][y]){
                    que.add(new int[] {x-1 , y, z+1});
                    visit[x-1][y] = true;
                }
            }

        }

        System.out.println(ans);
    }
}