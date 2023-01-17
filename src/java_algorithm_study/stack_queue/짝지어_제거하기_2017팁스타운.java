package java_algorithm_study.stack_queue;

import java.util.Stack;

public class 짝지어_제거하기_2017팁스타운 {
    public static int solution(String s) {
        if(s.length() == 0 || s.length()%2==1) return 0;

        if(isString(s)) return 1;
        else return 0;
    }

    public static boolean isString(String s){
        Stack<Character> stack = new Stack<>();
        int index = 0;

        stack.push(s.charAt(index++));

        while(index < s.length()){
            char c = s.charAt(index++);

            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
