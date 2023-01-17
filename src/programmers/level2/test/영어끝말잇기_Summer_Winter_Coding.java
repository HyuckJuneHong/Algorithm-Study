package programmers.level2.test;

import java.util.Stack;

public class 영어끝말잇기_Summer_Winter_Coding {
    /**
     * @param n : 참가자 수
     * @param words : 단어들
     * @return []{참가자번호, 첫 탈락자 번호}
     */
    public int[] solution(int n, String[] words) {
        int index = 0;
        int count = 2, result=1;

        Stack<String> stack = new Stack<>();
        stack.push(words[index++]);

        while(index < words.length){
            String now = stack.peek();
            String next = words[index++];

            if(stack.contains(next) || now.charAt(now.length()-1) != next.charAt(0)){
                return new int[]{count, result};
            }else{
                stack.push(next);
            }

            if(count == n){
                count = 1;
                result++;
            }else{
                count++;
            }
        }

        return new int[]{0, 0};
    }
}
