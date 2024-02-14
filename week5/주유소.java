package test;
//입력 
//N(도시의 개수)
//N-1개의 도로의 길이
//N개의 주유소 리터당 가격

//출력
//끝까지 가는데 최소기름비용

//아이디어
//현재 리터가격을 변수로 잡고
//다음 도시의 리터가 더 싸다면 현재 리터 변수 변경
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] roads = new long[n-1];
		long[] oils = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			roads[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			oils[i] = Integer.parseInt(st.nextToken());
		}
		long result = 0;
		long price = oils[0];
		result += price*roads[0];
		
		for(int i=1; i<n-1; i++) {
			if(price>oils[i]) price = oils[i];
			result+= price*roads[i];
		}
		System.out.println(result);
	}
}