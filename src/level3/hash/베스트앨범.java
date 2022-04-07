package level3.hash;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> genresMap = new HashMap<>();
        Map<Integer, Integer> playsMap = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            if(genresMap.containsKey(genres[i])){
                genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
            }else{
                genresMap.put(genres[i], plays[i]);
            }
            playsMap.put(i, plays[i]);
        }

        List<Map.Entry<String, Integer>> genresEntryList = new ArrayList<>(genresMap.entrySet());
        genresEntryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Map.Entry<Integer, Integer>> playEntryList = new ArrayList<>(playsMap.entrySet());
        playEntryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> genresEntry : genresEntryList){
            int count = 0;
            for(Map.Entry<Integer, Integer> playEntry : playEntryList){
                if(genres[playEntry.getKey()].equals(genresEntry.getKey())){
                    answerList.add(playEntry.getKey());
                    count++;
                    if(count == 2){
                        break;
                    }
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i=0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
