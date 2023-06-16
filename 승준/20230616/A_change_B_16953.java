import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class A_change_B_16953 {
    static int minCnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end, 0);

        if (minCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCnt + 1);
        }
    }

    private static void bfs(long start, long end, int count) {
        if (start == end) {
            minCnt = Math.min(minCnt, count);
            return;
        }

        if (start > end){
            return;
        }

        bfs(start * 2, end, count + 1);
        bfs(start * 10 + 1, end, count + 1);
    }
}
