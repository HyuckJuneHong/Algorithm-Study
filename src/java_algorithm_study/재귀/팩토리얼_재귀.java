package java_algorithm_study.재귀;

public class 팩토리얼_재귀 {

    /**
     * @param n
     * @return r(5) = 5*r(4) = 5*4*r(3) = 5*4*3*r(2) = 5*4*3*2*1
     */
    public int recursion(int n){
        if(n == 1){
            return 1;
        }else{
            return n*recursion(n-1);
        }
    }

    public static void main(String[] args) {
        팩토리얼_재귀 T = new 팩토리얼_재귀();

        System.out.println(T.recursion(5));
    }
}
