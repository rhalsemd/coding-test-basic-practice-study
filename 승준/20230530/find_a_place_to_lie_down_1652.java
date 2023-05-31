import java.io.*;
import java.util.*;

public class find_a_place_to_lie_down_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0 + " " + 0);
            return;
        }

        char[][] newArray = new char[n][n];

        for (int i = 0; i < n; i++) {
            newArray[i] = br.readLine().toCharArray();
        }

        int r_cnt = countLyingPlaces(newArray, n);
        int c_cnt = countLyingPlaces(transpose(newArray), n);

        System.out.println(r_cnt + " " + c_cnt);

    }

    private static int countLyingPlaces(char[][] arr, int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int spaceCnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    spaceCnt++;
                } else {
                    if (spaceCnt >= 2) {
                        cnt++;
                    }
                    spaceCnt = 0;
                }
            }
            if (spaceCnt >= 2) {
                cnt++;
            }
        }
        return cnt;
    }

    private static char[][] transpose(char[][] arr) {
        int n = arr.length;
        char[][] transposed = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = arr[j][i];
            }
        }
        return transposed;
    }
}
