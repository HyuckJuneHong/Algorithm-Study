package programmers.level3.hash;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answerList = new ArrayList<>();       //정답을 담을 리스트
        Map<String, Integer> genresMap = new HashMap<>();   //장르를 담을 맵<장르, 총 재생수>
        Map<Integer, Integer> playsMap = new HashMap<>();   //재생 수를 담을 맵 <i, 각 재생수>

        for(int i=0; i<genres.length; i++){
            if(genresMap.containsKey(genres[i])){ //이미 있을 시
                genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
            }else{ // 없을 시
                genresMap.put(genres[i], plays[i]);
            }
            playsMap.put(i, plays[i]); //각 재생 수
        }

        //genresMap을 엔트리맵으로 가져와 리스트로 반환 List<Map<장르, 총 재생수>
        List<Map.Entry<String, Integer>> genresEntryList =  new ArrayList<>(genresMap.entrySet());
        genresEntryList.sort((o1, o2) -> o2.getValue() - o1.getValue()); //총 재생 수 기준으로 내림 차순 정렬

        //playMap을 엔트리맵으로 가져와 리스트로 반환 List<Map<i, 각 재생수>
        List<Map.Entry<Integer, Integer>> playEntryList = new ArrayList<>(playsMap.entrySet());
        playEntryList.sort((o1, o2) -> o2.getValue() - o1.getValue()); //각 재생 수 기준으로 내림 차순 정렬

        for (Map.Entry<String, Integer> genresEntry : genresEntryList){ //정렬된 genresEntryList 반복
            int count = 0;  //가장 많이 재생된 두 곡만 해야 하기 때문에 변수 추가
            for(Map.Entry<Integer, Integer> playEntry : playEntryList){ //정렬된 PlayEntryList 반복
                if(genres[playEntry.getKey()].equals(genresEntry.getKey())){ //genres[i]와 genresEntry 키가 같으면
                    answerList.add(playEntry.getKey()); // playEntry 각 재생값 추가
                    count++;
                    if(count == 2){ //가장 많이 재생된 2곡만 추가
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
