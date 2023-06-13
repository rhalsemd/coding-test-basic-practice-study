import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ucpc_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idxU = str.indexOf('U');
        int idxC = str.indexOf('C', idxU + 1);
        int idxP = str.indexOf('P', idxC + 1);
        int idxC2 = str.indexOf('C', idxP + 1 );

        if(idxU >= 0 && idxC >= 0 && idxP >= 0 && idxC2 >= 0){
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
