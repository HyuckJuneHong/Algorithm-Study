package programmers.level1.example;

public class X만큼_간격있는_N개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        answer[0] = x;

        for(int i=1; i<n; i++){
            answer[i] = answer[i-1] + x;
        }

        return answer;
    }
}
