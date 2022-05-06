package level2.heap;

import java.util.PriorityQueue;

public class 더맵개 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int sNum : scoville){
            pQ.offer(sNum);
        }

        while (pQ.peek() < K && pQ.size() > 1){
            answer++;
            int sum = pQ.poll();
            sum += pQ.poll()*2;
            pQ.offer(sum);

        }

        if(pQ.size() <= 1 && pQ.peek() < K){
            return -1;
        }

        return answer;
    }
}
