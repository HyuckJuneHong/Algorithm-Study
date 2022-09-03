package programmers.level2.stack_queue;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(1);
            }else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
