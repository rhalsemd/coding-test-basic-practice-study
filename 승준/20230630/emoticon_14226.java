import java.io.*;
import java.util.*;
public class emoticon_14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 화면, 클립보드
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        dp[1][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int clip = current[1];

            // 목표 개수에 도달한 경우
            if (now == n) {
                System.out.println(dp[now][clip]);
                break;
            }

            // 화면에 있는 이모티콘을 복사해서 클립보드에 저장
            if (dp[now][now] == -1) {
                dp[now][now] = dp[now][clip] + 1;
                queue.add(new int[]{now, now});
            }

            // 클립보드에 있는 이모티콘을 화면에 붙여넣기
            if (now + clip <= n && dp[now + clip][clip] == -1) {
                dp[now + clip][clip] = dp[now][clip] + 1;
                queue.add(new int[]{now + clip, clip});
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            if (now - 1 >= 0 && dp[now - 1][clip] == -1) {
                dp[now - 1][clip] = dp[now][clip] + 1;
                queue.add(new int[]{now - 1, clip});
            }
        }
    }
}
