import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int x; 
	static int y; 
	static int n; 
	static int maxX; 
	static int maxY; 
	static ArrayList<Integer> colCutList = new ArrayList<>();
	static ArrayList<Integer> rowCutList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	x = Integer.parseInt(st.nextToken());
    	y = Integer.parseInt(st.nextToken());

    	colCutList.add(0);
    	colCutList.add(x);
    	rowCutList.add(0);
    	rowCutList.add(y);

    	n = Integer.parseInt(br.readLine());

    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int type = Integer.parseInt(st.nextToken()); // 자르는 점선 타입

    		if(type == 0) {
    			rowCutList.add(Integer.parseInt(st.nextToken()));
    		}

    		else if(type == 1) {
    			colCutList.add(Integer.parseInt(st.nextToken()));
    		}
    	}

    	Collections.sort(colCutList);
    	Collections.sort(rowCutList);

    	rowCut();
    	colCut();
    	System.out.println(maxX * maxY);

    	br.close();
    }

    public static void rowCut() {
    	for(int i = 0; i < rowCutList.size() - 1; i++) {
    		int dis = rowCutList.get((i+1)) - rowCutList.get(i); // 두 점 사이의 거리
    		maxY = Math.max(maxY, dis); // 간격 가장 넓은 것 찾기
    	}
    }

    public static void colCut() {
    	for(int i = 0; i < colCutList.size() - 1; i++) {
    		int dis = colCutList.get((i+1)) - colCutList.get(i); // 두 점 사이의 거리
    		maxX = Math.max(maxX, dis); // 간격 가장 넓은 것 찾기
    	}
    }
}