package level3.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }else{
                map.put(genres[i], plays[i]);
            }
            indexMap.put(i, genres[i]);
        }

        String[] sortMap = map.keySet().toArray(new String[0]);
        Arrays.sort(sortMap, (key1, key2) -> map.get(key1) - map.get(key2));

        //To do ..... 너무 어렵다.

        return answer;
    }
}
