import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N+1];

        for (int i= 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< N; i++){
            if (arr[2][i+1]<arr[2][i]){
                arr[2][i+1] = arr[2][i];
            }
            if (i +arr[0][i] < N + 1 && arr[2][i+arr[0][i]] <arr[2][i] + arr[1][i]){
                arr[2][i+arr[0][i]] = arr[2][i] + arr[1][i];

            }
        }
        System.out.println(arr[2][N]);
    }
}