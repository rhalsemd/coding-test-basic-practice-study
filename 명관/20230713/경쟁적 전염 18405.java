import java.util.*;
import java.io.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class Main {
		static class Virus {
        int x, y, type, time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }
    }
    static int[][] map;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int n, k;
    static Queue<Virus> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];
        map = new int[n + 1][n + 1];

        pq = new PriorityQueue<>((v1, v2) ->
                v1.time == v2.time ? v1.type - v2.type : v1.time - v2.time);

        for (int i = 1; i <= n; i++) {
            map[i] = stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0)
                    pq.add(new Virus(j, i, map[i][j], 0));
            }
        }
        int[] endCondition = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(bfs(endCondition));
    }

    private static int bfs(int[] end) {

        while (!pq.isEmpty()) {

            Virus cur = pq.poll();

            if (cur.time >= end[0])
                break;

            for (int i = 0; i < dx.length; i++) {

                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (!isRange(nextX, nextY) || map[nextY][nextX] != 0)
                    continue;

                map[nextY][nextX] = cur.type;
                pq.add(new Virus(nextX, nextY, cur.type, cur.time + 1));
            }
        }
        return map[end[1]][end[2]];
    }

    static boolean isRange(int x, int y) {
        return x > 0 && y > 0 && x <= n && y <= n;
    }
}