import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
						st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
 
            Integer arr[] = new Integer[N];
 
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
 
            Arrays.sort(arr, Collections.reverseOrder());
 
            int max = arr[0];
            int min = arr[N - 1];
 
            int sub = Integer.MIN_VALUE;
 
            for (int j = 0; j < arr.length - 1; j++) {
                sub = Math.max(arr[j] - arr[j + 1], sub);
            }
 
            sb.append("Class " + (i + 1) + "\n");
            sb.append("Max " + max + ", " + "Min " + min + ", " + "Largest gap " + sub + "\n");
        }
 
        System.out.println(sb);
    }
}