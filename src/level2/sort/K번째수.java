package level2.sort;

import java.util.*;

public class K번째수 {
    public String solution(int[] numbers) {
        String answer = "";

        Map<Integer, Integer> numbersMap = new HashMap<>();

        List<Integer> numbersList = new ArrayList<>();
        for(int i : numbers){
            numbersList.add(i);
        }
        numbersList.sort(Collections.reverseOrder());

        for(int i=0; i<numbersList.size(); i++){
            if(numbersList.get(i) >= 10){
                numbersMap.put(i, numbersList.get(i)/10);
            }else{
                numbersMap.put(i, numbersList.get(i));
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
