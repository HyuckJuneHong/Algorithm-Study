package java_algorithm_study.string;

import java.util.Scanner;

public class Test1_문자거리 {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        int minN = 1000;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                minN = 0;
                answer[i] = minN;
            }else{
                minN++;
                answer[i] = minN;
            }
        }
        minN = 1000;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c){
                minN = 0;
                answer[i] = minN;
            }else{
                minN++;
                answer[i] = Math.min(answer[i], minN);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test1_문자거리 test = new Test1_문자거리();
        Scanner kb=new Scanner(System.in);
        String str = kb.next();
        char c=kb.next().charAt(0);

        for(int x: test.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
