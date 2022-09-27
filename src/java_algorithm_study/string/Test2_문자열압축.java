package java_algorithm_study.string;

import java.util.Scanner;

public class Test2_문자열압축 {

    public String solution(String str){
        String answer = "";
        int count = 1;
        str += " ";

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }else{
                answer += str.charAt(i);
                if(count>1){
                    answer += String.valueOf(count);
                    count = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test2_문자열압축 test = new Test2_문자열압축();
        Scanner kb=new Scanner(System.in);
        String str = kb.next();
        System.out.println(test.solution(str));
    }
}
