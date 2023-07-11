import java.io.*;
import java.util.*;

public class drawing_line_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> line = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] point = {x, y};
            line.add(point);
        }

        line.sort((a, b) -> Integer.compare(a[0], b[0]));

        int start = line.get(0)[0];
        int end = line.get(0)[1];

        int total = 0;
        for(int i = 1; i < n; i++){
            if (line.get(i)[0] > end){
                total += end - start;
                start = line.get(i)[0];
                end = line.get(i)[1];
            }
            else {
                end = Math.max(end, line.get(i)[1]);
            }
        }

        total += end - start;

        System.out.println(total);
    }
}
