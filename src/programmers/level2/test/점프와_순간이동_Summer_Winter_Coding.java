package programmers.level2.test;

public class 점프와_순간이동_Summer_Winter_Coding {
    static int sum = 1;
    /**
     * 한번에 K 칸 점프하거나 (K만큼의 건전지 사용)
     * 햔재거리 * 2 위치로 이동 (에너지 사용 X)
     * @param n : 이동할 거리
     * @return : 최소 에너지량
     */
    public static int solution(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        rc(n);
        return sum;
    }

    private static int rc(int n){
        if(n%2 == 1) sum++;

        if(n/2==1) return 0;
        else{
            return rc(n/2);
        }
    }

    /*
    T.C
    5 -> 2-1 -> 1-0
    6 -> 3-0 -> 1-1
    5000 -> 2500-0 -> 1250-0 -> 625-0 -> 312-1 -> 156-0 -> 78-0 -> 39-0 -> 19-1 -> 9-1 -> 4-1 -> 2-0 -> 1-0
     */
    public static void main(String[] args) {
        System.out.println(solution(5000));
    }
}
