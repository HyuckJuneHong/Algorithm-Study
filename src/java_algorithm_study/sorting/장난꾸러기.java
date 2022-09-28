package java_algorithm_study.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 장난꾸러기 {

    public List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();

        int[] temp = arr.clone(); //깊은 복사
        Arrays.sort(temp);
        for(int i=0; i<n; i++){
            if(arr[i] != temp[i]){
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        장난꾸러기 T = new 장난꾸러기();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }

        for(int x : T.solution(n, arr)){
            System.out.print(x+ " ");
        }
    }
}
