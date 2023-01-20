package programmers.level2.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class 괄호_회전하기_월간코드챌린지시즌2 {
    public int solution(String s) {
        int answer = 0;
        if(s.equals("")) return answer;
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()){
            queue.offer(c);
        }

        for(int i=0; i<s.length(); i++){
            if(isString(queue.stream().collect(Collectors.toList()))){
                answer++;
            }
            char c = queue.poll();
            queue.offer(c);
        }
        return answer;
    }

    public boolean isString(List<Character> s){
        Stack<Character> stack = new Stack<>();

        for(char c : s){
            if(c=='(' || c==')'){
                if(c==')'){
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '(') stack.pop();
                    else return false;
                } else{
                    stack.push(c);
                }
            }else if(c=='{' || c=='}') {
                if (c == '}') {
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '{') stack.pop();
                    else return false;
                } else{
                    stack.push(c);
                }
            }else if(c== '[' || c==']') {
                if (c == ']') {
                    if(stack.isEmpty()) return false;
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                } else {
                    stack.push(c);
                }
            }
        }

        if(!stack.isEmpty())
            return false;
        return true;
    }
}
