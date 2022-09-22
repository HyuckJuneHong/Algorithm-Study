package programmers.level2.완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;

    public static int solution(String numbers) {
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i);
        }

        dfs("", 0);

        return set.size();
    }

    //백트레킹
    public static void dfs(String str, int index){
        int number;
        if(!str.equals("")){
            number = Integer.parseInt(str);
            if(isPrime(number)){
                set.add(number);
            }
        }

        if(index == arr.length){
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            dfs(str+arr[i], index+1);
            visited[i] = false;
        }
    }

    public static boolean isPrime(int num){
        if(num==0 || num==1){
            return false;
        }
        for(int i=2; i*i<=num; i++){//2
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
