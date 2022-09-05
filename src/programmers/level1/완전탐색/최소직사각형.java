package programmers.level1.완전탐색;

import java.util.Collections;
import java.util.PriorityQueue;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]){
                pq.offer(sizes[i][0]);
                pq2.offer(sizes[i][1]);
            }else{
                pq.offer(sizes[i][1]);
                pq2.offer(sizes[i][0]);
            }
        }

        return (pq.peek() * pq2.peek());
    }

}
