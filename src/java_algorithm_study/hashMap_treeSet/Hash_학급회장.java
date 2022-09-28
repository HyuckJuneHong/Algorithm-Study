package java_algorithm_study.hashMap_treeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash_학급회장 {
    public char solution(int n, String s){
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char key : map.keySet()){
            if(map.get(key)> max){
                max = map.get(key);
                answer = key;
            }
        }

        return  answer;
    }

    public static void main(String[] args) {
        Hash_학급회장 T = new Hash_학급회장();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        String str = kb.next();

        System.out.println(T.solution(n, str));
    }
}
