package java_algorithm_study.이분검색_결정알고리즘;

import java.util.Arrays;

/**
 * 이분 검색은 무조건 정렬이 됐다는 것을 가정하고 해야 한다.
 */
public class 이분검색 {
    static int n;                       //Array Size
    static int m;                       //검색할 값
    static int[] arr = new int[n];      //검색할 Array
    public static void main(String[] args) {
        Arrays.sort(arr);
        int lt=0, rt=n-1, answer = 0;

        while(lt <= rt){
            int mid=(lt+rt)/2;
            if(arr[mid] == m){
                answer = mid+1;
                break;
            }
            if(arr[mid] > m)
                rt = mid-1;
            else
                lt = mid+1;
        }
        System.out.println(answer);
    }
}
