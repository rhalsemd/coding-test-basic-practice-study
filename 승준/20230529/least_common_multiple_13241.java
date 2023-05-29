package codingTest;

import java.io.*;
import java.util.*;

public class least_common_multiple_13241 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		
//		최대공약수
		long gcd = findGCD(a, b);
		
//		두 숫자 곱에서 최대공약수 나누면 최소공배수임
		long ans = (a * b) / gcd;
		System.out.println(ans);
	}
	
	public static long findGCD(long a, long b){
		while (b != 0) {
			long temp = b;
			b = a% b;
			a = temp;
		}
		return a;
	}
}
