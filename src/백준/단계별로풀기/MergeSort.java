package 백준.단계별로풀기;

import java.io.*;
import java.util.*;

public class MergeSort {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stringTokenizer;
    static int n, k;
    static int[] temp;

    public void recursion(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            recursion(arr, l, mid);
            recursion(arr,mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    public void merge(int[] arr, int l, int mid, int r){
        int i=l, j=mid+1, count = 0;
        while(i<=mid && j <= r){
            if(arr[i] <= arr[j]){
                temp[count++] = arr[i++];
            }else{
                temp[count++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[count++] = arr[i++];
        }
        while(j<=r){
            temp[count++] = arr[j++];
        }
        i = l;
        count = 0;
        while(i<=r){
            arr[i++] = temp[count++];
        }
    }


    public void solution(int[] arr, int l, int r) throws IOException {
        recursion(arr, l, r);
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException {
        MergeSort T = new MergeSort();
        String s1 = bufferedReader.readLine();
        String s = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(s1, " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(s, " ");
        int[] arr = new int[n];
        temp = new int[n];
        int l = 0, r = arr.length-1;
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());

        T.solution(arr, l, r);
    }
}
