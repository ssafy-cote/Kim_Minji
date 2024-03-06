package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 97908 kb
// 552 ms
public class 미생물게임 {
    static int N, M, K, result;
    static int[][] counting;
    static Micro[] micros;
    static int[] dxs = {0, -1, 0, 1, 0}; // 그대로, 상, 좌, 하, 우
    static int[] dys = {0, 0, -1, 0, 1};
    static class Micro implements Comparable<Micro>{
        int x, y, cnt, dir;
        Micro(int x, int y, int cnt, int dir){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Micro o) {
            return this.x-o.x == 0 ? ((this.y-o.y)==0? o.cnt-this.cnt : this.y-o.y) : this.x-o.x;
        }

    }
    static boolean isMedicine(int x, int y){
        return x==0 || y ==0 || x==N-1 || y==N-1;
    }

    static void move(){
        for(Micro m: micros){
            if(m.cnt == 0) continue;
            int nx = m.x+dxs[m.dir];
            int ny = m.y+dys[m.dir];
            m.x = nx;
            m.y = ny;
            if(isMedicine(nx, ny)){ // 약품이면 재정의
                m.cnt = m.cnt/2;
                m.dir = m.dir<=2? m.dir+2 : (m.dir+2)%4;
            }
        }
        Arrays.sort(micros);
    }

    static void merge(){
        counting = new int[N][N];
        for(Micro m: micros){
            counting[m.x][m.y] += m.cnt;
        }
        for(Micro m: micros){
            m.cnt = counting[m.x][m.y];
            counting[m.x][m.y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = 0;

            micros = new Micro[K];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                if(dir == 3) dir = 2;
                else if(dir == 2) dir = 3;
                micros[i] = new Micro(x, y, cnt, dir);
            }
            Arrays.sort(micros);
            while(M-->0){
                move();
                merge();
            }

            for(Micro m: micros){
                result += m.cnt;
            }
            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
