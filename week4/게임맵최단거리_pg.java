package test;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static int answer=Integer.MAX_VALUE;
	static boolean[][] visited;
	static int n, m;
	static Deque<Member> q;
	static class Member {
		int x;
		int y;
		int v; // 떨어진 정도
		public Member(int x, int y, int v){
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y && y<m;
	}
	
	static void bfs(int[][] maps) {
		int dxs[] = {0, 1, 0, -1};
		int dys[] = {1, 0, -1, 0};
		while(!q.isEmpty()) {
			Member tmp = q.pop();
			int x = tmp.x;
			int y = tmp.y;
			int v = tmp.v;
			
			if(x==n-1 && y==m-1) {
				answer = Math.min(answer, v); // 최솟값
			}
			
			for(int i=0; i<4; i++) {
				int nx = x+dxs[i];
				int ny = y+dys[i];
				
				if(inRange(nx, ny) && !visited[nx][ny]) {
					if(maps[nx][ny] == 1) {
						q.add(new Member(nx, ny, v+1));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
    public int solution(int[][] maps) {
        q = new ArrayDeque<>();
        n = maps.length;
		m = maps[0].length;
		visited = new boolean[n][m];
		
		Member mem = new Member(0, 0, 1);
		q.add(mem);
		visited[0][0] = true;
		bfs(maps);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}