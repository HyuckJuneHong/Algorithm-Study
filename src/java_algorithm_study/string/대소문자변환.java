package java_algorithm_study.string;

import java.util.Scanner;

public class 대소문자변환 {

    public String solution(String str){
        String answer="";

        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)){
                answer += Character.toUpperCase(c);
            }else{
                answer += Character.toLowerCase(c);
            }
        }

        return answer;
    }

    public String solution2(String str){
        String answer="";

        for(char c : str.toCharArray()){
            if(c >= 97 && c<= 122) {
                answer += (char)(c - 32);
            } else{
                answer += (char)(c + 32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        대소문자변환 test = new 대소문자변환();

        Scanner in=new Scanner(System.in);
        String str = in.next();

        System.out.println(test.solution(str));
    }
}
