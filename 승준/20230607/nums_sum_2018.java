import java.io.*;

public class nums_sum_2018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int sum = 0;
        int left = 1;
        int right = 1;

        while (left <= N) {
            if (sum < N) {
                sum += right;
                right++;
            } else if ( sum > N ) {
                sum -= left;
                left++;
            } else {
                count++;
                sum -= left;
                left++;
            }
        }

        System.out.println(count);
    }
}
