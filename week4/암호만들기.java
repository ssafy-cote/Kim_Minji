package test;

import java.util.Arrays;
import java.util.Scanner;
// 메모리 17692 kb
// 시간 216ms
public class 암호만들기 {
	static int L, C;
	static String[] alpha;
	static String[] selected;
	static StringBuilder sb = new StringBuilder();
	private static void combination(int cnt, int start) {
		if(cnt==L) {
			int moeum = 0;
			int jaeum = 0;
			for(int i=0; i<L; i++) {
				if(selected[i].equals("a")|| selected[i].equals("e") || selected[i].equals("o")|| selected[i].equals("i") || selected[i].equals("u")) {
					moeum+=1;
					continue;
				}
				jaeum++;
			}
			if(moeum>0 && moeum<L && jaeum>=2) {
				for(int i=0; i<L; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			selected[cnt] = alpha[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		selected = new String[L];
		alpha = new String[C];
		for(int i=0; i<C; i++) {
			alpha[i] = sc.next();
		}
		Arrays.sort(alpha);
		
		combination(0, 0);
		System.out.println(sb);
	}
}