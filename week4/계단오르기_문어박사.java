package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//메모리 14136 kb
//시간 124 ms
public class 계단오르기_문어박사 {
	static int n;
	static int[] stair;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[n+1];
		dp = new int[n+1][3]; 
		
		for(int i=1; i<=n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + stair[i];
			dp[i][2] = dp[i-1][1] + stair[i];
		}
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}
}