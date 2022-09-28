package java_algorithm_study.결정알고리즘_searching;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간정하기_결정알고리즘 {

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt=1;
        int rt=arr[n-1];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid) >= m){
                answer = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }

        return answer;
    }

    public int count(int[] arr, int dist){
        int count = 1;
        int lt = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]-lt >= dist){
                count++;
                lt = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        마구간정하기_결정알고리즘 T = new 마구간정하기_결정알고리즘();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        System.out.println(T.solution(n, m, a));
    }

}
