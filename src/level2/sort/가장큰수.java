package level2.sort;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> numbersList = new ArrayList<>();
        Map<Integer, Integer> numbersMap = new HashMap<>();

        for(int i : numbers){
            numbersList.add(i);
        }
        numbersList.sort((o1, o2) ->  Integer.parseInt("" + o2 + o1) - Integer.parseInt("" + o1+o2));

        for(int i=0; i<numbersList.size(); i++){
            for(int j=0; j<numbersList.size(); j++){

            }
        }

        List<Map.Entry<Integer, Integer>> numbersEntry = new ArrayList<>(numbersMap.entrySet());
        numbersEntry.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Integer, Integer> map : numbersEntry){
            answer += "" + numbersList.get(map.getKey());
        }

        return answer;
    }
}
