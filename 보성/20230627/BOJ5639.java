import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr = new int[3][10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        arr[0][0] = 1000001;

        int i = 1;
        while(true){
            input = br.readLine();
            if (input == null || input.equals("")){
                break;
            }
            arr[0][i] = Integer.parseInt(input);
            first(0, i);
            i++;
        }

        last(1);
    }
    public static void first(int node, int i){
        if (arr[0][node] < arr[0][i]){
            if(arr[2][node] == 0){
                arr[2][node] = i;
            }else{
                first(arr[2][node], i);
            }
        }else{
            if(arr[1][node] == 0){
                arr[1][node] = i;
            }else{
                first(arr[1][node], i);
            }
        }
    }

    public static void last(int i){
        if (i>0){
            last(arr[1][i]);
            last(arr[2][i]);
            System.out.println(arr[0][i]);
        }
    }
}