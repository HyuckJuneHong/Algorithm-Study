package java_algorithm_study.string;

import java.util.Scanner;

public class 문자찾기 {

    public int solution(String str, char t){
        int answer=0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t){
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String str, char t){
        int answer=0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for(char c : str.toCharArray()){
            if(c==t)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        문자찾기 test = new 문자찾기();

        Scanner in=new Scanner(System.in);

        String str = in.next();
        char c = in.next().charAt(0);

        System.out.println(test.solution(str, c));
    }
}
