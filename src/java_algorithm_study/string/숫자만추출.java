package java_algorithm_study.string;

import java_algorithm_study.Main;

import java.util.Scanner;

public class 숫자만추출 {
    public int solution2(String str){
        int answer = 0;

        for(char c : str.toCharArray()){
            if(c >= 48 && c<=57){
                answer = answer*10+(c-48);
            }
        }

        return answer;
    }

    public int solution(String str){
        String answer = "";

        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                answer += c;
            }
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Main test = new Main();
        Scanner kb=new Scanner(System.in);
        String str = kb.next();
        System.out.println(test.solution(str));
    }
}
