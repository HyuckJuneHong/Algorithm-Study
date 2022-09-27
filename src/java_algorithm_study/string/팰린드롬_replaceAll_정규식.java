package java_algorithm_study.string;

import java.util.Scanner;

public class 팰린드롬_replaceAll_정규식 {

    public String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String temp = new StringBuilder(str).reverse().toString();

        if(str.equals(temp)){
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        팰린드롬_replaceAll_정규식 test = new 팰린드롬_replaceAll_정규식();
        Scanner kb=new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(test.solution(str));
    }
}
