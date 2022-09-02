package programmers.study;

import java.util.PriorityQueue;

public class 더맵개 {

    public int 더맵개(int[] scoville, int K){
        //최소 섞음 음식 = 가장 맵지 않은 스코빌 + (두번째로 맵지않은 스코빌*2)

        int answer = 0;
        int currentScoville;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville){
            pq.offer(s);
        }

        while(pq.peek() < K && pq.size() > 1){
            currentScoville = pq.poll() + (pq.poll()*2);
            pq.offer(currentScoville);
            answer++;
        }

        if(pq.peek() < K){
            return -1;
        }

        return answer;
    }
}
