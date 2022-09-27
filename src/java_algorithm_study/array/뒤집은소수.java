package java_algorithm_study.array;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            int reverse = reverse(arr[i]);
            if(isPrime(reverse)){
                answer.add(reverse);
            }
        }
        return answer;
    }

    //소수 확인
    public boolean isPrime(int num){
        if(num==1)
            return false;

        for(int i=2; i<num; i++){
            if(num%i==0){
                return false;
            }
        }

        return true;
    }

    //뒤집기
    public int reverse(int num){
        int result = num;
        int res = 0;
        while(result > 0){
            int temp = result%10;
            res=res*10+temp;
            result = result/10;
        }

        return res;
    }

    public static void main(String[] args) {
        뒤집은소수 T = new 뒤집은소수();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x: T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}
