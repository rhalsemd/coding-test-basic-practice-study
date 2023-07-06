import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class decrease_number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Long> nums = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(combinations, new ArrayList<>(), 0, 10, i);

            for (List<Integer> combination : combinations) {
                Collections.sort(combination, Collections.reverseOrder());
                StringBuilder sb = new StringBuilder();
                for (int num : combination) {
                    sb.append(num);
                }
                nums.add(Long.parseLong(sb.toString()));
            }
        }

        Collections.sort(nums);

        try {
            System.out.println(nums.get(n));
        } catch (NumberFormatException e) {
            System.out.println(-1);
        }
    }

    public static void generateCombinations(List<List<Integer>> combinations, List<Integer> current, int start, int n, int r) {
        if (r==0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < n; i++){
            current.add(i);
            generateCombinations(combinations, current, i+1,  n, r-1);
            current.remove(current.size()-1);
        }
    }
}