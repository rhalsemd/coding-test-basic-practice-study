import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Bucket {
        int A, B;

        public Bucket(int a, int b) {
            A = a;
            B = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liter = new int[3];
        for (int i = 0; i < 3; i++) {
            liter[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] result = new boolean[liter[2] + 1];
        result[liter[2]] = true;
        
        int[] from = {0, 0, 1, 1, 2, 2};
        int[] to = {1, 2, 0, 2, 0, 1};

        Queue<Bucket> queue = new LinkedList<>();
        boolean[][] visit = new boolean[liter[0] + 1][liter[1] + 1];

        queue.add(new Bucket(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Bucket cur = queue.poll();
            int A = cur.A, B = cur.B;
            int C = liter[2] - A - B;

            for (int i = 0; i < 6; i++) {
                int[] n = {A, B, C};

                n[to[i]] += n[from[i]];
                n[from[i]] = 0;

                if (n[to[i]] > liter[to[i]]) {
                    n[from[i]] = n[to[i]] - liter[to[i]];
                    n[to[i]] = liter[to[i]];
                }

                if (!visit[n[0]][n[1]]) {
                    visit[n[0]][n[1]] = true;
                    queue.add(new Bucket(n[0], n[1]));

                    if (n[0] == 0) {
                        result[n[2]] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= liter[2]; i++) {
            if (result[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}