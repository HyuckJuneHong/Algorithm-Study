package programmers.level1.완전탐색;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=3; i++){
            map.put(i, 0);
        }

        for(int i=0; i< answers.length; i++){
            if(student1[i%student1.length] == answers[i]){
                map.put(1, map.get(1)+1);
            }
            if(student2[i%student2.length] == answers[i]){
                map.put(2, map.get(2)+1);
            }
            if(student3[i%student3.length] == answers[i]){
                map.put(3, map.get(3)+1);
            }
        }

        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<>(map.entrySet());
        listMap.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> list = new ArrayList<>();
        Integer max = listMap.get(0).getValue();

        for(Map.Entry<Integer, Integer> m : listMap){
            if(m.getValue().equals(max)){
                list.add(m.getKey());
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
