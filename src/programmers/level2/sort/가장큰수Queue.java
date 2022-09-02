package programmers.level2.sort;

import java.util.PriorityQueue;

public class 가장큰수Queue {
    public String solution(int[] numbers) {

        String answer = "";
        PriorityQueue<String> numberPq = new PriorityQueue<>(
                (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));

        for(int num : numbers){
            numberPq.offer(String.valueOf(num));
        }

        while(!numberPq.isEmpty()){
            answer += numberPq.poll();
        }

        if(answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }
}
