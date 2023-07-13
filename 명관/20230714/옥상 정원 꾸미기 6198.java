import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        int list[];
        int N;
        long ans = 0;
        
        N = Integer.parseInt(st.nextToken());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= list[i]) {
                ans += (i - (stack.peek()[1] + 1));
                stack.pop();
            }
            stack.push(new int[] { list[i], i });
        }
 
        int pe = N - 1;
        while (!stack.isEmpty()) {
            ans += (pe - stack.peek()[1]);
            stack.pop();
        }
        
        System.out.println(ans);
    }
}