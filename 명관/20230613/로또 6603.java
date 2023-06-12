import java.io.*;
import java.util.*;
 
public class Main {
    static int N ;
    static int[] arr;
    static boolean[] result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
 
            if(N==0){
                break;
            }
            arr = new int[N];
            result = new boolean[N];
            for (int i = 0; i <N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            DFS(0, 0);
            System.out.println();
 
        }
    }
    private static void DFS(int start, int depth){
        if(depth == 6){
            for (int i = 0; i <N ; i++) {
                if(result[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
 
        for (int i = start; i <N ; i++) {
            result[i] = true;
            DFS(i+1, depth+1);
            result[i] = false;
        }
 
    }
}