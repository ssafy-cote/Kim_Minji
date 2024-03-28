package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
	static int H, W, result;
	static boolean[][] grid;
	static boolean start, right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		grid = new boolean[H][W];
		int temp;
		for(int i=0; i<W; i++) {
			temp = Integer.parseInt(st.nextToken());
			for(int j=0; j<temp; j++) {
				grid[j][i] = true;
			}
		}
		for(int i=0; i<H; i++) {
			start = false;
			int tempResult = 0;
			for(int j=0; j<W; j++) {
				if(!start && grid[i][j]) { // start가 false고 값이 true
					start = true;
				}
				if(start && grid[i][j]) { // start가 true고 값이 true
					start = true;
					result += tempResult;
					tempResult = 0;
				}
				if(start && !grid[i][j]) { //start && 값이 false
					tempResult ++;
				}
				
			}
		}
		System.out.println(result);
	}

}
