import java.io.*;
import java.util.*;
public class decorating_the_rooftop_garden_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];
        for(int i=0;i<N;i++){
            buildings[i]= Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long count = 0;

        for(int b : buildings) {
            while(!stack.isEmpty() && stack.peek() <= b) {
                stack.pop();
            }
            stack.push(b);
            count += stack.size() - 1;
        }
        System.out.println(count);
    }
}
