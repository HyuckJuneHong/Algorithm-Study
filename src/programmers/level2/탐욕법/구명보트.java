package programmers.level2.탐욕법;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class 구명보트 {
    /**
     * 구명 보트 크기 : 2
     *
     * @param people : 사람들의 몸무게
     * @param limit : 무게제한
     * @return : 구명보트 최소 개수
     */
    public static int solution(int[] people, int limit) {
        int answer = 0, weight = limit;


        Arrays.sort(people);
        Deque<Integer> queue = new LinkedList<>(Arrays.stream(people).boxed().collect(Collectors.toList()));

        while(!queue.isEmpty()){
            limit -= queue.pollLast();

            if(!queue.isEmpty() && limit >= queue.peekFirst()){
                queue.pollFirst();
            }

            limit = weight;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{70, 50, 80};
        int l = 100;
        System.out.println(solution(arr, l));
    }
}
