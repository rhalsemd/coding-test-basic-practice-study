import java.io.*;
import java.util.*;

public class lotto_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) {
                break;
            }

            int[] lst = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                lst[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(combinations, new ArrayList<>(), lst, 0);

            for (List<Integer> combination : combinations) {
                for (int num : combination) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        br.close();
    }

    public static void generateCombinations(List<List<Integer>> combinations, List<Integer> currentCombination, int[] lst, int start) {
        if (currentCombination.size() == 6) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < lst.length; i++) {
            currentCombination.add(lst[i]);
            generateCombinations(combinations, currentCombination, lst, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
