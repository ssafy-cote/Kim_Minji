package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 생일 {
	static class Person implements Comparable<Person>{
		String name;
		int month, date, year;
		Person(String name, int date, int month, int year){
			this.name = name;
			this.date = date;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Person o) {
			return (o.year-this.year)==0? ((o.month-this.month)==0 ? o.date-this.date : o.month-this.month): o.year-this.year;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(people);
		
		System.out.println(people[0].name);
		System.out.println(people[n-1].name);
	}

}
