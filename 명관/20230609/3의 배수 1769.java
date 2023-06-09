import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        
        int ans = 0;
        
        while(true) {
            long sum = 0;
            if(x.length() == 1) {
                break;
            }
            for(int i = 0; i < x.length(); i++) {
                sum += Integer.parseInt(String.valueOf(x.charAt(i)));
            }
            ans++;
            x = String.valueOf(sum);
        }
        
        if(Integer.parseInt(String.valueOf(x)) % 3 == 0) {
            System.out.println(ans);
            System.out.println("YES");
        }else {
            System.out.println(ans);
            System.out.println("NO");
        }
    }
}