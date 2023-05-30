import java.io.*;
import java.util.*;

public class find_a_place_to_lie_down_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        if (n == 1){
            System.out.println(0 + " " + 0);
            return;
        }

        char[][] newArray = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            newArray[i] = row.toCharArray();
        }

//       가로로 카운트 2이상이면 가로 갯수 +1
        int r_cnt = 0;
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (newArray[j][k] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        r_cnt++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                r_cnt++;
            }
        }

//        세로로 카운트하기
        int c_cnt = 0;
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (newArray[k][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        c_cnt++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                c_cnt++;
            }
        }
        System.out.println(r_cnt + " " + c_cnt);
    }
}
