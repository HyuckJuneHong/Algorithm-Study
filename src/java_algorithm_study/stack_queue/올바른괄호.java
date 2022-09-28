package java_algorithm_study.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {

    private String solution(String n) {
        Stack<Character> stack = new Stack<>();

        for(char c : n.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{//')'
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {

        올바른괄호 T = new 올바른괄호();
        Scanner kb = new Scanner(System.in);
        String n=kb.next();

        System.out.println(T.solution(n));

    }

}
