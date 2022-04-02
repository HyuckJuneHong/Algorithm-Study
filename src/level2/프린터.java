package level2;

import java.util.*;

public class 프린터 {

    static public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities); // 1 1 1 1 1 9
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();// 1 1 9 1 1 1
            if(i == priorities[size - answer]){ //1 9
                answer++;
                l--;  //
                if(l < 0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0) //
                    l=que.size()-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] p = new int[]{1, 1, 9, 1, 1, 1};
        int answer = solution(p, 0);
        System.out.println(answer);
    }
}
