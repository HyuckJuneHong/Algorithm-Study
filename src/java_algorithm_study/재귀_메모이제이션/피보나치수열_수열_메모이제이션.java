package java_algorithm_study.재귀_메모이제이션;

/**
 * 재귀로 피보나치 수열을 구현하면 시간복잡도가 매우 오래 걸림
 * 반복문이 훨씬 빠르다.
 *
 * 조금 더 빨리하는 방법이 있을까?
 * 있음 -> 바로 fibo 배열 사용하기 그래도 오래걸림...ㅋㅋ
 *
 * 그럼 더 빠른 방법이 있을까?
 * 있음 -> 바로 메모이이션
 */
public class 피보나치수열_수열_메모이제이션 {

    //배열을 사용하면 더 빠르다.
    static int[] fibo;
    static int[] fibo2;

    public int recursion(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return recursion(n-2) + recursion(n-1);
        }
    }

    public int recursion_좀_빠른_방법(int n){
        if(n == 1){
            return fibo[n] = 1;
        }else if(n == 2){
            return fibo[n] = 1;
        }else{
            return fibo[n] = recursion_좀_빠른_방법(n-2) + recursion_좀_빠른_방법(n-1);
        }
    }

    public int recursion_진짜_빠른_방법(int n){
        if(fibo2[n] > 0){
            return fibo2[n];
        }else if(n == 1){
            return fibo2[n] = 1;
        }else if(n == 2){
            return fibo2[n] = 1;
        }else{
            return fibo2[n] = recursion_진짜_빠른_방법(n-2) + recursion_진짜_빠른_방법(n-1);
        }
    }


    public static void main(String[] args) {
        피보나치수열_수열_메모이제이션 T = new 피보나치수열_수열_메모이제이션();
        int n = 10;

        //느린 방법
        for(int i=1; i<=n; i++){
            System.out.print(T.recursion(i) + " ");
        }

        System.out.println();

        //좀 빠른 방법
        fibo = new int[n+1];
        T.recursion_좀_빠른_방법(n);
        for(int i=1; i<=n; i++){
            System.out.print(fibo[i] + " ");
        }

        System.out.println();

        //진짜 빠른 방법(메모이제이션)
        fibo2 = new int[n+1];
        T.recursion_진짜_빠른_방법(n);
        for(int i=1; i<=n; i++){
            System.out.print(fibo2[i] + " ");
        }

    }
}
