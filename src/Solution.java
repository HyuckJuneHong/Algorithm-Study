import java.util.*;

class Solution {

    /**
     * 순서 다르면 다른 튜플
     * 원소의 개수 n
     * @param s : 특정 튜플 표현 집합 문자열
     * @return s가 표현하는 튜플을 배열에 담아 리턴
     */
    public static int[] solution(String s) {

        s = s.replace("{", "");
        StringTokenizer stringTokenizer = new StringTokenizer(s, "}");
        List<List<Integer>> list = new ArrayList<>();
        int size = stringTokenizer.countTokens();
        Set<Integer> result = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int[] answer = new int[size];

        for(int i=0; i<size; i++){
            StringTokenizer value = new StringTokenizer(stringTokenizer.nextToken(), ",");
            list.add(new ArrayList<>());
            while(value.hasMoreTokens()){
                list.get(i).add(Integer.parseInt(value.nextToken()));
            }
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.size() - o2.size();
        });

        for(List<Integer> tuple : list){
            for(int i=0; i<tuple.size(); i++){
                if(!result.contains(tuple.get(i))){
                    temp.add(tuple.get(i));
                    result.add(tuple.get(i));
                }
            }
        }

        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }
}