package java_algorithm_study.string;

import java.util.Scanner;

public class Test3_암호 {
    public String solution(int n, String str){
        String answer = "";
        for(int i=0; i<n; i++){
            String temp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            str = str.substring(7);
            answer += (char)num;
        }
        return answer;
    }

    public static void main(String[] args) {
        Test3_암호 test = new Test3_암호();
        Scanner kb=new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(test.solution(n, str));
    }
}
