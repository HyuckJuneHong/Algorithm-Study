package java_algorithm_study.hashMap_treeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash_아나그램 {

    private String solution(String str1, String str2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for(char c : str2.toCharArray()){
            if(!map.containsKey(c) || map.get(c)==0){
                return "NO";
            }
            map.put(c, map.get(c)-1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Hash_아나그램 T = new Hash_아나그램();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();

        System.out.println(T.solution(str1, str2));
    }

}
