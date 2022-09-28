package java_algorithm_study.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {

    private String solution(String n) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        //foreach
        for(char c : n.toCharArray()){
            if(c==')'){
                while(stack.peek() != '('){//( false
                    stack.pop();
                }
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        for(int i=0; i<stack.size(); i++){
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        괄호문자제거 T = new 괄호문자제거();
        Scanner kb = new Scanner(System.in);
        String n=kb.next();

        System.out.println(T.solution(n));

    }
}
