import java.io.*;
import java.util.*;

public class yourname_14653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        double ans = 0;
        double cnt = 0;
        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String rank = st.nextToken();

            for (int j = 0; j < 10; j++) {
                if (rank.equals(gradeList[j])) {
                    ans += score * gradeScore[j];
                    if (j != 9) {
                        cnt += score;
                    }
                }
            }
        }
        double average = ans / cnt;
        if (ans == 0 || cnt == 0) average = 0.000000;
        System.out.printf("%.6f\n", average);
    }
}
