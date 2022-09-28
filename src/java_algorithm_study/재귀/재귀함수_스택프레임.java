package java_algorithm_study.재귀;

/** 재귀는 Stack Frame 이다. (매개, 지역, 복귀)
 *
 * stack [ recursion(3) -> 3line15(대기) / recursion(2) -> 2line15(대기) / recursion(1) -> 1line15(대기)
 *         / recursion(0) -> line12 -> 1line15 -> 2line15 -> 3line15 -> End ]
 */
public class 재귀함수_스택프레임 {

    public void recursion(int n){
        if(n == 0){
            return;
        }else{
            System.out.println(n); //선입선출
            recursion(n-1);
            System.out.println(n); //선입후출
        }
    }

    public static void main(String[] args) {
        재귀함수_스택프레임 T = new 재귀함수_스택프레임();

        T.recursion(3);
    }
}
