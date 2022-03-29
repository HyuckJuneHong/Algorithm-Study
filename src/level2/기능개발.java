package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){

            //d = 남은 작업 수 / 진도율
            double d = (100-progresses[i])/(double)speeds[i];
            //result = 작업일
            int result = (int)Math.ceil(d);
            if(!q.isEmpty() && q.peek() < result){
                list.add(q.size());
                q.clear();
            }
            q.offer(result);
        }
        list.add(q.size());

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
