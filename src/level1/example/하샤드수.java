package level1.example;

public class 하샤드수 {
    public static boolean solution(int x) {
        int b = x;
        int sum = 0;

        while(x/10 != 0){
            sum += x%10;
            x = x/10;
        }
        sum += x;

        if(b%sum == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(111) + "");
    }
}
