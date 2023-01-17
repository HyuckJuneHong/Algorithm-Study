package programmers.level2.etc;

public class 숫자의표현 {
    private static int solution(int n) {
        int answer = 0;

        for(int i=n; i>=1; i--){
            if(isNumber(n, i)){
                answer++;
            }
        }
        return answer;
    }

    private static boolean isNumber(int n, int index){
        int sum=0;
        while(index != -1){
            if(sum == n){
                return true;
            }else if(sum > n){
                return false;
            }else{
                sum += index;
            }
            index--;
        }

        return false;
    }
}
