import java.util.*;
import java.io.*;

public class Main {
		static class info{
	    int count;
	    int copy_count;
	    int time;
	    info(int count, int copy_count, int time){
	        this.count = count;
	        this.copy_count = copy_count;
	        this.time = time;
		  }
		}
    public static final int maximum = 20001;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        boolean check[][] = new boolean[maximum][maximum];
        Queue<info> emoticon = new LinkedList<>();
        
        int ans = 99999;
        emoticon.add(new info(1, 0, 0));
        check[1][0] = true;
        while(!emoticon.isEmpty()){
            info info = emoticon.poll();
            int count = info.count;
            int copy_count = info.copy_count;
            int time = info.time;
           
            if(N == count){
                ans = Math.min(ans, time); 
                break;
            }
            
            if(count*2<maximum){
								emoticon.add(new info(count, count, time+1));
						}
            if(count-1>=0 && !check[count-1][copy_count]){
                emoticon.add(new info(count-1, copy_count, time+1));
                check[count-1][copy_count] = true;
            } 
            if(count+copy_count<maximum && !check[count+copy_count][copy_count]){
                emoticon.add(new info(count+copy_count, copy_count, time+1));
                check[count+copy_count][copy_count] = true;
            } 
            
        }
        System.out.println(ans);
    }
}