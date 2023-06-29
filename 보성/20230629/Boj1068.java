import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int root = 0;
//        부모 노드 저장 및 루트노드 저장
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1) {
                root = i;
                continue;
            }if (i != target){
                arr[temp][arr[temp][0] + 1] = i;
                arr[temp][0] ++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        if (root != target){
            que.offer(root);
        }

        while(!que.isEmpty()){
            int now = que.poll();
//           자식이 없으면 ++
            if(arr[now][0] == 0){
                ans ++;
            }else{
                for(int j = 1; j <=arr[now][0]; j++){
                    que.offer(arr[now][j]);
                }
            }
        }
        System.out.println(ans);
    }
}