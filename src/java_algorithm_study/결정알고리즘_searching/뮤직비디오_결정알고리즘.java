package java_algorithm_study.결정알고리즘_searching;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오_결정알고리즘 {
    public int solution(int n, int m, int[] arr){
        int answer=0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid)<=m){
                answer = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return answer;
    }

    public int count(int[] arr, int capacity){
        int count=1;
        int sum=0;
        for(int i : arr){
            if(sum+i > capacity){
                count++;
                sum = i;
            }else{
                sum += i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        뮤직비디오_결정알고리즘 T = new 뮤직비디오_결정알고리즘();
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
