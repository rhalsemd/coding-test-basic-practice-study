import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        }
    }

    public static int getMinMoves(int len, int cx, int cy, int tx, int ty) {
        boolean[][] visited = new boolean[len][len];
        // 큐랑 연결리스트 CS이론 확인
        Queue<Point> queue = new LinkedList<>();
        return 1;
    }
}
