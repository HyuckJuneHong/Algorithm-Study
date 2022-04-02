package level2;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<participant.length; i++){
            if(map.containsKey(participant[i])){
                map.put(participant[i], map.get(participant[i]) + 1);
            }else{
                map.put(participant[i], 1);
            }
        }

        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i]))
                map.put(completion[i], map.get(completion[i]) - 1);
        }

        for(String key : map.keySet()){
            if(map.get(key) == 1)
                answer = key;
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] a = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b = new String[]{"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(a, b));
    }
}
