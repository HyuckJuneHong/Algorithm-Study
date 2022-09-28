package java_algorithm_study.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {
    public int solution(int n1, int n2){
        int answer=0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n1; i++){
            queue.offer(i+1);
        }
        while (!queue.isEmpty()){
            for(int i=1; i<n2; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size()==1){
                answer = queue.poll();
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        공주구하기 T = new 공주구하기();
        Scanner kb = new Scanner(System.in);
        int n1=kb.nextInt();
        int n2=kb.nextInt();

        System.out.println(T.solution(n1, n2));
    }
}
