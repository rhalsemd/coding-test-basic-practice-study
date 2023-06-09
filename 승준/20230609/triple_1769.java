import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class triple_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] lst = st.nextToken().split("");

        int cnt = 0;
        int sum = 0;
        String ans = "NO";

        for(int i = 0; i < lst.length; i++) {
            sum += Integer.parseInt(lst[i]);
        }

        if (lst.length > 1) {
            ++cnt;
        }

        while (sum >= 10) {
            ++cnt;
            lst = String.valueOf(sum).split("");
            sum = 0;

            for(int i = 0; i < lst.length; i++) {
                sum += Integer.parseInt(lst[i]);
            }
        }

        if (sum < 10) {
            if (sum % 3 == 0) {
                ans = "YES";
            }
        }

        System.out.println(cnt);
        System.out.println(ans);
    }
}
