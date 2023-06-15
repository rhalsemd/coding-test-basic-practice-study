import java.util.*;
import java.io.*;

public class Main {
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] chk;
    static int[] diry = {-1, 0, 1, 0};
    static int[] dirx = {0, 1, 0, -1};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        chk = new boolean[m][n];
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < k; i++) {
						st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!chk[i][j] && map[i][j] == 0) {
                    answer++;
                    list.add(bfs(i, j));
                }
            }
        }
        System.out.println(answer);
        Collections.sort(list);
        String res = "";
        for(int i=0; i<list.size(); i++){
            res +=(list.get(i)+" ");
        }
        System.out.println(res.trim());
    }

    public static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        int answer = 1;
        queue.add(new Node(y, x));
        chk[y][x] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if(now_y>=0 && now_y<m && now_x>=0 && now_x<n){
                    if(!chk[now_y][now_x] && map[now_y][now_x]==0){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] = true;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}