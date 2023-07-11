import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, belt[];
    static boolean robot[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(simulation());
    }
    public static int simulation(){
        int result = 0;

        while(K > 0){
            result++;

            int temp = belt[2*N-1];
            for(int i=2*N-1; i>0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;

            robot[N-1] = robot[N-2] = false;
            for(int i=N-1; i>1 ; i--){
                if(!robot[i-2] || robot[i] || belt[i] <= 0){ 
                    if(robot[i-2]){
                        robot[i-1] = true;
                        robot[i-2] = false;
                    }
                    continue;
                }
                robot[i] = true;
                robot[i-2] = false;
                if(--belt[i] == 0){
                    K--;
                }
            }

            //3
            if(!robot[0] && belt[0] > 0){
                robot[0] = true;
                if(--belt[0] == 0){
                    K--;
                }
            }
        }

        return result;
    }
}