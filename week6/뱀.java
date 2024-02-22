package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * 1. 입력 받으면서 사과 표시
 * 2. 방향들의 정보를 담는 클래스, 배열 생성 (3, D)
 * 2.5 . 뱀 머리 x, y,, 꼬리 x, y  좌표 담는 클래스 생성(뱀의 위치)
 * 3. 오른쪽으로 90도, 왼쪽으로 90도 로직
 * 
 * 종료 조건 : 벽이랑 뱀과 부딪히면 게임 끝
 */
public class 뱀 {
	static int n, k;
	static int grid[][];
	static int[] dxs = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dys = {1, 0, -1, 0};
	static class Direction{
		int t; // 초
		int flag; // 방향
		Direction(int t, int flag){
			this.t = t;
			this.flag = flag;
		}
	}
	
	static class Snake{
		int x, y, d;
		Snake(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		Deque<Snake> s = new ArrayDeque<Snake>();
		grid = new int[n][n];
		int appleNum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<appleNum; i++) {
			st = new StringTokenizer(br.readLine());
			// 사과 위치
			grid[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		int dirNum = Integer.parseInt(br.readLine());
		Direction[] dirs = new Direction[dirNum];
		for(int i=0; i<dirNum; i++) {
			st = new StringTokenizer(br.readLine());
			int tt = Integer.parseInt(st.nextToken());
			int dir = st.nextToken().charAt(0)=='D'?1:-1;
			dirs[i] = new Direction(tt, dir); // 위치 정보 저장
		}
		int hx = 0, hy=0, cd = 0;
		s.add(new Snake(hx, hy, cd));
		grid[hx][hy]=-1; 
		int idx = 0;
		int time = 0;
		while(true) {
			time++;
			
			Snake tempSnake = s.peek(); // 앞에머리 뽑아서
			
			hx = tempSnake.x+dxs[cd]; 
			hy = tempSnake.y+dys[cd];
			
			// 범위 벗어나면
			if(!inRange(hx, hy) || grid[hx][hy]==-1) { // 머리, 꼬리 범위 벗어나면 끝.
				System.out.println(time);
				System.exit(0);
			}
			
			if(grid[hx][hy] == 0) { // 사과가 없으면, 꼬리 줄여줌
				Snake tmpSnake = s.pollLast(); // 꼬리 잘고
				grid[tmpSnake.x][tmpSnake.y] = 0; // 뱀 위치 표시 지워줌
			} 
			else if(grid[hx][hy]==1) { // 사과가 있으면
				grid[hx][hy]=0;
			}
			
			s.addFirst(new Snake(hx, hy, cd)); // 머리에 넣어줌
			grid[hx][hy] = -1;
			
			// 다 끝나고 몇초 후 ~ 방향 바꿈
			if(idx<dirNum) {
				if(dirs[idx].t==time) {
					cd = (cd+dirs[idx].flag+4)%4;
					idx++;
				}
			}
		}
	}
}
