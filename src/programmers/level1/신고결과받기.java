package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] result = new int[id_list.length];

        //report 문자열 배열 List로 중복 제거 후 생성
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Integer> answer = new HashMap<>();

        for(String s : id_list){
            answer.put(s, 0);
        }

        for (String s : list) {

            //" "을 기준으로 문자열이 배열로 나뉘고 [1] 요소의 문자열 출력
            String target = s.split(" ")[1];
            //Map count에 target 문자열을 키로 넣고, 해당 키 값 있다면 1 증가, 없다면 0+1)
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        for(String s : list){
            String[] target = s.split(" ");
            if(count.get(target[1]) >= k){
                answer.put(target[0], answer.get(target[0]) + 1);
            }
        }

        for(int i=0; i< id_list.length; i++){
            result[i] = answer.get(id_list[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] answer = new int[10];

        Arrays.fill(answer, 0);
        String[] a = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] b = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi", "apeach neo", "neo frondo","apeach muzi"};
        answer = solution(a, b, 2);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}

