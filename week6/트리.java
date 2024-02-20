package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리 {
	static int n, m;
	static int[][] grid;
	static boolean[] visited;
	static int node, vertex;
	static void dfs(int start) {
		visited[start] = true;
		node ++;
		for(int i=1; i<=n; i++) {
			if(grid[start][i]==1) vertex++;
			if(grid[start][i]==1 & !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static boolean isCycle() {
		if(node == vertex/2+1) return false; 
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
			m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
			if(n==0 && m==0) break;
			grid = new int[n+1][n+1];
			visited = new boolean[n+1];
			for(int i=0; i<m; i++) { // m개만큼 간선 만들어줌
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				grid[a][b] = 1;
				grid[b][a] = 1;
			}
			int tempResult = 0;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					node = vertex = 0;
					if(grid[i][j] == 1 && !visited[i]) {
						dfs(i);
						if(isCycle()) continue; // cycle있으면 넘어감
						tempResult ++;
					}
				}
			}
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					tempResult++;
				}
			}
			if(tempResult == 0) {
				sb.append("Case "+idx+": No trees."+"\n");
			} else if(tempResult == 1) {
				sb.append("Case "+idx+": There is one tree."+"\n");				
			} else {
				sb.append("Case "+idx+": A forest of "+tempResult+" trees."+"\n");				
			}
			idx++;
		}
		System.out.println(sb);
	}
}
