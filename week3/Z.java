package algo0130;

import java.util.Scanner;

public class Z {
	static int n;
	static int r;
	static int c;
	static int result;
	public static void z(int cnt) {
		int temp = (int)Math.pow(2, cnt-1);
		if(cnt == -1) {
			return;
		}
		
		
		if(r<temp && c<temp) {
		} else if(r<temp && c>= temp) {
			result+=temp*temp;
			c-=temp;
		} else if(r>=temp && c<temp) {
			result+=temp*temp*2;
			r-=temp;
		} else {
			r-=temp;
			c-=temp;
			result+=temp*temp*3;
		}
		z(cnt-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		if(n>1) {
			z(n);
		} else {
			result = r*2+c;
		}
		System.out.println(result);
	}
}
