package java_algorithm_study.재귀_메모이제이션;

public class 이진수출력_재귀 {

    public void recursion(int n){
        if(n==0){
            return;
        }else{
            recursion(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        이진수출력_재귀 T = new 이진수출력_재귀();

        T.recursion(11);
    }
}
