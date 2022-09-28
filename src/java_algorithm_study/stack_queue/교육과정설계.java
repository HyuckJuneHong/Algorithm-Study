package java_algorithm_study.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {
    public String solution(String n, String k){
        String answer="YES";
        Queue<Character> queue = new LinkedList<>();
        for(char c : n.toCharArray()){
            queue.offer(c);
        }

        for(char c2 : k.toCharArray()){
            if(queue.contains(c2)){
                if(c2 != queue.poll()){
                    return "NO";
                }
            }
        }

        if(!queue.isEmpty())
            return "NO";

        return answer;
    }

    public static void main(String[] args) {
        교육과정설계 T = new 교육과정설계();
        Scanner kb = new Scanner(System.in);
        String n=kb.next();
        String k=kb.next();

        System.out.println(T.solution(n , k));
    }
}
