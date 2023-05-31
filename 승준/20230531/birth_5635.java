import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.StringTokenizer;
public class birth_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st_n = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st_n.nextToken());

        String[][] userInfoLst = new String[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st_userInfo = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (st_userInfo.hasMoreTokens()) {
                    String token = st_userInfo.nextToken();
                    userInfoLst[i][j] = token;
                }
            }
        }

        int[] mx_age = {0, 0, 0};
        int[] mn_age = {1000, 1000, 1000};
        String oldest = "";
        String youngest = "";

        for (int i = 0; i < n; i++) {
            int birthYear = Integer.parseInt(userInfoLst[i][3]);
            int birthMonth = Integer.parseInt(userInfoLst[i][2]);
            int birthDay = Integer.parseInt(userInfoLst[i][1]);

            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

            Period period = Period.between(birthDate, currentDate);
            int[] age = {period.getYears(), period.getMonths(), period.getDays()};

            if (isGreater(age, mx_age)) {
                mx_age = age;
                oldest = userInfoLst[i][0];
            }

            if (isSmaller(age, mn_age)) {
                mn_age = age;
                youngest = userInfoLst[i][0];
            }
        }

        System.out.println(youngest);
        System.out.println(oldest);
    }

    private static boolean isGreater(int[] age1, int[] age2) {
        if (age1[0] > age2[0]) {
            return true;
        } else if (age1[0] == age2[0] && age1[1] > age2[1]) {
            return true;
        } else return age1[0] == age2[0] && age1[1] == age2[1] && age1[2] > age2[2];
    }

    private static boolean isSmaller(int[] age1, int[] age2) {
        if (age1[0] < age2[0]) {
            return true;
        } else if (age1[0] == age2[0] && age1[1] < age2[1]) {
            return true;
        } else return age1[0] == age2[0] && age1[1] == age2[1] && age1[2] < age2[2];
    }
}
