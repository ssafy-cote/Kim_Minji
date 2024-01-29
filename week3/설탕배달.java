package test;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		
		int[] dp = new int[n];
		Arrays.fill(dp, 5000);
		dp[2] = 1;
		if(n>=5) {
			dp[4] = 1;
			
			for(int i = 5; i <n; i++) {
				if (dp[i-5] != 0 || dp[i-3] != 0) {
					int t = Math.min(dp[i-5], dp[i-3]);
					if(t!=5000) dp[i] = t+ 1;
				}
			}
		}
		
		if(dp[n-1]!=5000) {
			result = dp[n-1];
		}
		else result = -1;
		System.out.println(result);
	}
}