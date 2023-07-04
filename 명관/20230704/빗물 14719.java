import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] info = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			info[i]= Integer.parseInt(st.nextToken());
		}
		
		int wall = info[0];
		int wall_idx = 0;
		int res = 0;
		
		for(int i=1;i<w;i++	) {
			int left = 0;
			int right = 0;
			for(int j=i-1;j>=0;j--) {
				left = Math.max(left, info[j]);
			}
			
			for(int j=i+1;j<w;j++) {
				right = Math.max(right, info[j]);
			}
			
			if(left<info[i]||right<info[i]) continue;
			
			res += Math.min(left, right)-info[i];
		}
		System.out.println(res);
	}
}