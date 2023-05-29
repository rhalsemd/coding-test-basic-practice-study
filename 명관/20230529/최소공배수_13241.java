import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        br.close();

        if(A > B){
            bw.write(A*B/GCD(A, B) + "\n"); 
        }else if(A < B){
            bw.write(A*B/GCD(B, A) + "\n");
        }else{
            bw.write(A + "\n");
        }

        bw.flush();
        bw.close();
    }
    static long GCD(long A, long B){
        while(B != 0){
            long R = A%B;
            A = B; 
            B = R;
        }
        return A;
    }
}