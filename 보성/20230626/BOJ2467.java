import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static Long[] arr;
    static int N;
    static Long ans;
    static Long[] ans2 = new Long[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        ans = 2000000001L;

        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (ans > Math.abs(arr[i] + arr[mid])){
                    ans = Math.abs(arr[i] + arr[mid]);
                    ans2[0] = arr[i];
                    ans2[1] = arr[mid];
                }
                if (arr[mid] + arr[i] < 0){
                    left = mid + 1;
                } else if (arr[mid] + arr[i] == 0) {
                    break;
                } else {
                    right = mid;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(ans2[0]);
        sb.append(" ");
        sb.append(ans2[1]);

        System.out.println(sb);
    }
}