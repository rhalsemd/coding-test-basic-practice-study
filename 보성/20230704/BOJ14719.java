import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int H = Integer.parseInt(st.nextToken());
            for (int h = 0; h < H; h++) {
                arr[h][i] = 1;
            }
        }
        int ans = 0;

        for (int h = 0; h < N; h++) {
            boolean logic = false;
            int temp = 0;
            for (int w = 0; w < M; w++) {
                if (arr[h][w] == 1) {
                    if ( logic ){
                        ans += w - temp - 1;
                    }else{
                        logic = true;
                    }
                    temp = w;
                }
            }
        }
        System.out.println(ans);

    }
}