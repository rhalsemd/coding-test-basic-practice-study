import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long ans = -1L;
        Long res = 0L;
        boolean found = false;
        Long i = 0L;
        while (i<9876543211L){
            long num = i;
            long temp = -1;
            long stage =0;
            while (num > 0){
                if (num %10 > temp){
                    temp = num%10;
                    num = num /10;
                    stage ++;
                }else{;
                    break;
                }
            }
            if (num == 0){
                ans ++;

                if (ans == N){
                    res = i;
                    break;
                }
                i++;
                continue;
            }
            Long temp2 = 1L;
            for (Long j = 1L; j < stage; j ++){
                temp2 *= 10;
            }
            i += temp2;
        }
        System.out.println((ans == N) ? res : -1);
    }
}