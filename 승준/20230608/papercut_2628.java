import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class papercut_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st2.nextToken());

        List<Integer> col_lst = new ArrayList<Integer>();
        List<Integer> row_lst = new ArrayList<Integer>();
        for (int i = 0; i < c; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            Integer direction = Integer.parseInt(st3.nextToken());
            Integer cut = Integer.parseInt(st3.nextToken());
            if (direction == 0) {
                row_lst.add(cut);
            } else {
                col_lst.add(cut);
            }
        }
        Collections.sort(col_lst);
        Collections.sort(row_lst);

        int maxColGap = col_lst.isEmpty() ? col : col_lst.get(0);
        int maxRowGap = row_lst.isEmpty() ? row : row_lst.get(0);

        for (int i = 1; i < row_lst.size(); i++) {
            int rowGap = row_lst.get(i) - row_lst.get(i - 1);
            maxRowGap = Math.max(maxRowGap, rowGap);
        }
        if (!row_lst.isEmpty() && row - row_lst.get(row_lst.size()-1) > maxRowGap) {
            maxRowGap = row - row_lst.get(row_lst.size()-1);
        }

        for (int j = 1; j < col_lst.size(); j++) {
            int colGap = col_lst.get(j) - col_lst.get(j - 1);
            maxColGap = Math.max(maxColGap, colGap);
        }
        if (!col_lst.isEmpty() && col - col_lst.get(col_lst.size()-1) > maxColGap) {
            maxColGap = col - col_lst.get(col_lst.size()-1);
        }

        int maxArea = maxColGap * maxRowGap;
        System.out.println(maxArea);
    }
}
