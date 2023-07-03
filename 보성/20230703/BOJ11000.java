import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (arr[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}