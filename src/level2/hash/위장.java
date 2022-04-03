package level2.hash;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }else{
                map.put(clothes[i][1], 1);
            }
        }

        int result = 1;

        for(String key : map.keySet()){
            result *= (int)(map.get(key)+1);
        }
        answer = result -1;

        return answer;
    }
}
