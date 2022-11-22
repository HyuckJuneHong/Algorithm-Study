package programmers.devMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//a~z(3~6) + 숫자(0~6)
//new_id -> list X => new_id 추천
//else => new_id 를 S, N으로 분리
//=> 문자열 N 숫자로 변환한 값 = n /비어있는 N은 n=0
//new_id S+N1
//class Edge implements Comparable<Edge>{
//    String S = "";
//    String N = "";
//
//    public Edge(String s, String n) {
//        S = s;
//        N = n;
//    }
//
//    @Override
//    public int compareTo(Edge o) {
//        return Integer.parseInt(o.N) - Integer.parseInt(this.N);
//    }
//}
public class Solution {

    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        String N = "";
        String S = "";
        int count = 0;
        List<String> list = new ArrayList<>(Arrays.asList(registered_list));
        Collections.sort(list, Collections.reverseOrder());

        for(char c : new_id.toCharArray()){
            if(Character.isUpperCase(c)) return "S에 ";
            if(Character.isDigit(c))N += c;
            else S += c;
        }
        if(!new_id.equals(S+N)) return null;


        if(N.length() > 6 || S.length() < 3 || S.length() > 6) return null;
        if(N.length() > 0 && N.charAt(0)=='0') return null;

        if(list.contains(S+N)){
            for(char c : list.get(0).toCharArray()) {
                if (Character.isDigit(c)) N += c;
            }
            while(list.contains(S+N)){
                N = Integer.valueOf(N) + 1 + "";
            }
            return S + N;
        }

        return S+N;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
    T.solution(null, "asd123");
    }
}
