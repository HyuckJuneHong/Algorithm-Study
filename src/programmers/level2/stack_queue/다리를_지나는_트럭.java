package programmers.level2.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0, totalWeight = 0;

        Queue<Integer> bridgeQ = new LinkedList<>();
        Queue<Integer> readyQ = new LinkedList<>();

        for(int i=0; i<bridge_length; i++){
            bridgeQ.offer(0);
        }
        for(int i : truck_weights){
            readyQ.offer(i);
        }

        while(!bridgeQ.isEmpty()){

            totalWeight -= bridgeQ.poll();

            if(readyQ.isEmpty()){
                answer += bridge_length;
                break;
            }else{
                if(readyQ.peek() + totalWeight <= weight){
                    totalWeight += readyQ.peek();
                    bridgeQ.offer(readyQ.poll());
                }else{
                    bridgeQ.offer(0);
                }
            }
            answer++;
        }

        return answer;
    }
}
