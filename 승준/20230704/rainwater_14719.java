import java.io.*;
import java.util.*;

public class rainwater_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Integer> blocks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++){
            blocks.add(Integer.parseInt(st.nextToken()));
        }

        int result = calculater_rainwater(h, w, blocks);
        System.out.println(result);
    }

    public static int calculater_rainwater (int h, int w, List<Integer> blocks) {
        int total = 0;
        for (int i = 1; i < w-1; i++){
            int left_max = Collections.max(blocks.subList(0, i));
            int right_max = Collections.max(blocks.subList(i+1, blocks.size()));

            if (blocks.get(i) < left_max && blocks.get(i) < right_max) {
                total += Math.min(left_max, right_max) - blocks.get(i);
            }
        }
        return total;
    }
}
