import java.io.*;
import java.util.*;

public class solution_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] solution = Arrays.stream(br.readLine().split(" ")).mapToInt(item -> Integer.parseInt(item)).toArray();

        Arrays.sort(solution);

        int left = 0;
        int right = n - 1;
        int diff = Math.abs(solution[left] + solution[right]);
        int[] diff_match = {solution[left], solution[right]};

        while (left < right) {
            int sum_val = solution[left] + solution[right];
            if (Math.abs(sum_val) < diff) {
                diff = Math.abs(sum_val);
                diff_match[0] = solution[left];
                diff_match[1] = solution[right];
            }

            if (sum_val < 0) {
                left++;
            } else if (sum_val > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(diff_match[0] + " " + diff_match[1]);
    }
}
