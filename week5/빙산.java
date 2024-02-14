package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빙산 {
	static int[][] grid, tempGrid;
	static int N, M, tmp;
	static boolean flag;
	static boolean[][] visited;

	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempGrid[i][j] = grid[i][j];
			}
		}
		int[] dxs = { -1, 0, 1, 0 };
		int[] dys = { 0, 1, 0, -1 };
		flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] > 0) {
					flag = true;
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dxs[k];
						int ny = j + dys[k];
						if (inRange(nx, ny) && grid[nx][ny] == 0)
							++cnt;
					}
					tempGrid[i][j] -= cnt;
					if (tempGrid[i][j] < 0)
						tempGrid[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				grid[i][j] = tempGrid[i][j];
			}
		}
	}

	static void calc(int x, int y) {
		int[] dxs = { -1, 0, 1, 0 };
		int[] dys = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int nx = x + dxs[k];
			int ny = y + dys[k];
			if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] > 0) {
				visited[nx][ny] = true;
				calc(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		tempGrid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				tempGrid[i][j] = grid[i][j];
			}
		}

		int time = 0;
		flag = true;
		while (true) {
			
			tmp = 0;
			melt(); // 녹아
			
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] > 0 && !visited[i][j]) {
						visited[i][j] = true;
						tmp++;
						calc(i, j);
					}
				}
			}
			++time;
			if (tmp == 0 || tmp >= 2) {
				break;
			}
			if (!flag) {
				break;
			}
		}
		if (tmp==0) System.out.println("0");
		else System.out.println(time);
	}
}