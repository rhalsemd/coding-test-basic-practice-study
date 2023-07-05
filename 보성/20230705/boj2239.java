import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr = new int[9][9];
    public static boolean first = true;
    public static void dfs(int now) {
        int x = now / 9;
        int y = now % 9;
        if (!first){
            return;
        }
        if (now == 81) {
            for(int i =0; i <9; i ++){
                for (int j = 0; j<9; j ++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            first = false;
            return;
        }
        if (arr[x][y] == 0){
            for (int i = 1; i < 10; i++) {
                arr[x][y] = i;
                if (check(x, y)){
                    dfs(now + 1);
                }
                arr[x][y] = 0;
            }
        }else {
            dfs(now + 1);
        }
    }
    public static boolean check(int x, int y){
        boolean logic = true;
        for(int i = 0; i < 9; i ++){

            if (arr[x][i] == arr[x][y] && i != y){
                logic = false;
                break;
            }
            if (arr[i][y] == arr[x][y] && i != x){
                logic = false;
                break;
            }
            if (arr[3*(x/3)+i/3][3*(y/3)+i%3] == arr[x][y] && 3*(x/3)+i/3 != x && 3*(y/3)+i%3 != y){
                logic = false;
                break;
            }


        }

        return logic;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            char[] temp = new StringTokenizer(br.readLine()).nextToken().toCharArray();
            for (int h = 0; h < 9; h++) {
                arr[i][h] = Character.getNumericValue(temp[h]);
            }
        }
        dfs(0);

    }
}