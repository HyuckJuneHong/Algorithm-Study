package programmers.level2.etc;

public class 멀리_뛰기_피보나치_메모이제이션 {

    static long[] answer;

    /**
     * 1 2 3 4 5 6  7  8  9
     * 1 2 3 5 8 13 21 34 55
     * 1칸 혹은 2칸 이동
     * @param n : 거리
     * @return 도달하는 방법 갯수
     */
    public static long solution(int n) {
        answer = new long[n+1];

        fibo(n);
        return answer[n];
    }

    public static long fibo(int n){
        if(answer[n]>0) return answer[n];
        if(n==1) return answer[n] = 1;
        else if(n==2) return answer[n] = 2;

        return answer[n] = (fibo(n-2) + fibo(n-1))%1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(9));
    }

}
