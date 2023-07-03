import java.io.*;
import java.util.*;



public class Classroom_assignment_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] input = new int[2];
            st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            times.add(input);
        }

        times.sort(Comparator.comparingInt(a -> a[0]));

        int cnt = 0;
        PriorityQueue<Integer> end_times = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
            if (!end_times.isEmpty() && end_times.peek() <= start) {
                end_times.poll();
            }
            end_times.offer(end);
            cnt = Math.max(cnt, end_times.size());
        }

        System.out.println(cnt);
    }
}
