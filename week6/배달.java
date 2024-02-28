import java.util.*;
class Solution {
    
    static int INF = (int)1e9;

    public static int solution(int N, int[][] road, int K) {
        int[][] grid = new int[N+1][N+1];
		for(int i=0; i<road.length; i++) { // 그리드 연결해줌
			int a = road[i][0];
			int b = road[i][1];
			int v = road[i][2];
			if(grid[a][b] > 0){
                grid[a][b] = Math.min(grid[a][b], v);
                grid[b][a] = Math.min(grid[b][a], v);
                continue;
            }
			grid[a][b] = v;
            grid[b][a] = v;
		}
        
		int[] checked = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(checked, INF);
        
        checked[1] = 0;
		// dfs(1, 0); // 1번 마을에서 시작, 가중치는 0
        for(int i=1; i<=N; i++){
            int minIndex = -1;
            for(int j=1; j<=N; j++){
                if(visited[j]) continue;
                if(minIndex == -1 || checked[minIndex] > checked[j])
                    minIndex = j;
            }
            visited[minIndex] = true;
            for(int j=1; j<=N; j++){
                if(grid[minIndex][j] == 0) continue;
                checked[j] = Math.min(checked[j], checked[minIndex]+grid[minIndex][j]);
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(checked[i] <= K) answer++;
        }
		return answer;
    }
}