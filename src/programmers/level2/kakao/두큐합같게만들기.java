package programmers.level2.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Double> q1 = new LinkedList<>();
        Queue<Double> q2 = new LinkedList<>();
        double sum1=0, sum2=0;
        int max = queue1.length * 4;
        int count = 0;

        for(int i=0; i<queue1.length; i++){
            double n1 = queue1[i];
            double n2 = queue2[i];
            sum1 += n1;
            sum2 += n2;
            q1.offer(n1);
            q2.offer(n2);
        }

        while(true){
            if(sum1 == sum2){
                break;
            }
            else if(sum1 > sum2){
                double n1 = q1.poll();
                sum1 -= n1;
                sum2 += n1;
                q2.offer(n1);
            }else{
                double n2 = q2.poll();
                sum1 += n2;
                sum2 -= n2;
                q1.offer(n2);
            }
            count++;
            if(count > max){
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 1, 1, 1, 1
        };
        int[] arr2 = new int[]{
                1, 1, 1, 9, 1
        };

        System.out.println(solution(arr, arr2));
    }
}
