package programmers.level3.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    public static long[] solution(String[] operations) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        PriorityQueue<Long> reversePq = new PriorityQueue<>(Collections.reverseOrder());
        int countAdd = 0;
        int countDelet = 0;

        for(int i=0; i<operations.length; i++){
            if(operations[i].charAt(0) == 'I'){
                pq.offer(Long.valueOf(operations[i].substring(2)));
                reversePq.offer(Long.valueOf(operations[i].substring(2)));
                countAdd++;
            }
            if(operations[i].charAt(0) == 'D'){
                countDelet++;

                if(countAdd == countDelet){
                    reversePq.clear();
                    pq.clear();
                    countAdd = 0;
                    countDelet = 0;
                }
                if(operations[i].substring(2).equals("1") && !reversePq.isEmpty()){
                    reversePq.poll();
                }else if(operations[i].substring(2).equals("-1") && !pq.isEmpty()){
                    pq.poll();
                }
            }

        }

        long[] answer = new long[]{0, 0};

        if(pq.isEmpty() || reversePq.isEmpty()){
            return answer;
        }else if(pq.peek().equals(reversePq.peek())){
            return answer;
        }

        answer[0] = reversePq.peek();
        answer[1] = pq.peek();

        return answer;
    }
    public static void main(String[] args) {
        String[] str = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        solution(str);
    }
}
