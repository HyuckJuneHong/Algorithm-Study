import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer=0;
        int cnt=1;
        n--;
        while(n>0){
            cnt++;
            n-=cnt;
            if(n%cnt==0) answer++;
        }

        System.out.println("cnt = " + answer);
    }
}

