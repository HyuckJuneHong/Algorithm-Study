package programmers.level2.test;

public class 예상_대진표_2017탑스타운 {

    static int answer = 0;
    /**
     *
     * @param n : 참가자 수 (1번부터) / 이기면 진출 / 다음 라운드 다시 1번부터 배정 / 최종 한명 남을 때까지.
     * @param a : 첫 경기 참가자 번호1
     * @param b : 첫 경기 참가자 번호2
     * @return : a, b 붙는 라운드 수
     */
    public static int solution(int n, int a, int b) {
        if(b < a){
            int temp = b;
            b = a;
            a = temp;
        }
        recu(a, b);
        return answer;
    }

    public static void recu(int a, int b){

        answer++;
        if((b-a)==1 && a%2==1 && b%2==0){
            return;
        }else if(a==1){
            if(b%2==1) b+=1;
            recu(1, b/2);
        }else if(b==2){
            if(a%2==1) a+=1;
            recu(a/2, 2);
        }else{
            if(b%2==1) b+=1;
            if(a%2==1) a+=1;
            recu(a/2, b/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}
