import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class score_stat_5800 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int a = 0; a < n; a++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st2.nextToken());

            int[] lst = new int[t];
            for (int i = 0; i < t; i++) {
                lst[i] = Integer.parseInt(st2.nextToken());
            }

            Arrays.sort(lst);

            int max = lst[0];
            int min = lst[0];
            int largest = 0;

            for (int i = 1; i < lst.length; i++ ) {
                if (lst[i] - lst[i-1] > largest) {
                    largest = lst[i] - lst[i-1];
                }

                if (lst[i] > max) {
                    max = lst[i];
                }
                if (lst[i] < min) {
                    min = lst[i];
                }
            }
            System.out.println("Class " + (a+1));
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + largest);
        }
    }
}
