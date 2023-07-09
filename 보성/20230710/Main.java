
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Cor implements Comparable<Cor>{
        int n;
        int m;
        public Cor(int n, int m){
            this.n = n;
            this.m = m;
        }

        @Override
        public int compareTo(Cor o) {
            return this.n - o.n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Cor> arr = new ArrayList<>();
        for (int i = 0; i < N; i ++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            arr.add(new Cor(n, m));
        }
        Collections.sort(arr);
        int last = arr.get(0).n;
        int ans = 0;
        for (int i = 0; i < N; i ++){
            if (last < arr.get(i).m) {
                ans += (arr.get(i).n > last ? (arr.get(i).m - arr.get(i).n) : (arr.get(i).m - last));
                last = Math.max(arr.get(i).m, last);
            }
        }
        System.out.println(ans);
    }
}