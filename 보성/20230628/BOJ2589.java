import java.util.*;

public class Main {
    static int ans;
    static int N;
    static int M;
    static char[][]  arr;
    static int[][] visit;
    static int[][] delta = {{1, -1, 0, 0}, {0, 0, 1, -1}};

    public static void main(String[] args) {
        //입력11
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }
        //더이상 갈수 없는곳 찾고 해당 위치에서 bfs한번더
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 'L' && visit[i][j] == 0){
                    visit[i][j] = 1;
                    List<int[]> next = bfs(i, j);

                    for(int[] asd : next) {
                        //visit 초기화 안하니까 메모리 적게 써요
                        visit[asd[0]][asd[1]] ++;
                        bfs(asd[0], asd[1]);
                    }
                }
            }
        }
        System.out.println(ans);

    }
    //더이상 갈수 없는 좌표와 거리 찾기
    public static List<int[]> bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        List<int[]> list = new ArrayList<int[]>();
        que.offer(new int[] {x, y, 0});
        int[] now = new int[3];
        while (!que.isEmpty()) {
            now = que.poll();
            boolean togo = true;
            for (int i = 0; i < 4; i++) {
                int dx = now[0] + delta[0][i];
                int dy = now[1] + delta[1][i];
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && arr[dx][dy] == 'L' && visit[dx][dy] < visit[now[0]][now[1]]) {
                    que.offer(new int[] {dx, dy, now[2] + 1});
                    visit[dx][dy] = visit[now[0]][now[1]];
                    togo = false;
                }
            }
            if(togo){
                list.add(now);
                ans = Math.max(ans, now[2]);
            }
        }
        return list;
    }
}