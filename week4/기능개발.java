package test;
import java.util.*;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        int n = progresses.length;
        int[] left = new int[n];
        for(int i=0; i<n; i++){ // cnt 배열 만들기
            int tmp = (100-progresses[i])/speeds[i];
            if( (100-progresses[i])%speeds[i] == 0){
                left[i] = tmp;
                continue;
            }
            left[i] = tmp+1;
        }
        int result = 1;
        int biggest = left[0];
        for(int i=0; i<n-1; i++){
            if(biggest-left[i+1]>=0) ++result;
            else{
                answerList.add(result);
                biggest = left[i+1];
                result = 1;
            }
        }
        answerList.add(result);
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}