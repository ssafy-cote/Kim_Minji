import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1010_다리놓기 {
	static int answer, n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());		
			answer = 1;

			int min = Math.min(n, m - n);
			for (int i = 0; i < min; i++) {
				answer *= (m - i);
				answer /= (i + 1);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}