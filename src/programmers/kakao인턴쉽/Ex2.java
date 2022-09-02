package programmers.kakao인턴쉽;
import java.util.*;

public class Ex2 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long r1=0, r2=0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            r1 += queue1[i];
            r2 += queue2[i];
        }

        for(int i=0; i<queue1.length*3; i++){
            if(r1 == r2){
                return answer;
            }else if( r1 < r2){
                answer++;
                r2 -= q2.peek();
                r1 += q2.peek();
                q1.offer(q2.poll());
            }else if(r1 > r2 ){
                answer++;
                r1 -= q1.peek();
                r2 += q1.peek();
                q2.offer(q1.poll());
            }
        }

        return -1;
    }

    public static void main(String[] args) {
    }
}