import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class leave_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] t = new int[n+2];
        int[] p = new int[n+2];
        int[] dp = new int[n+2];

        for (int i = 0; i < n+2; i++){
            t[i] = 0;
            p[i] = 0;
            dp[i] = 0;
        }

        for (int i = 1 ; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < n+1; i++) {
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i+1]);
        }

        int max = 0;
        for (int i = 0; i < n+2; i++) {
            if (max < dp[i]){
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
