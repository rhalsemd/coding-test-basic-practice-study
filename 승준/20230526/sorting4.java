import java.io.*;
import java.util.*;

public class sorting4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Integer[] lst = new Integer[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int ele = Integer.parseInt(input.nextToken());
            lst[i] = ele;
        }
        Arrays.sort(lst, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            bw.write(lst[i] + '\n');
        }

//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < n; i++){
//            sb.append(lst[i]).append('\n');
//        }
//
//        System.out.print(sb.toString());
        bw.flush();
        bw.close();
    }
}
