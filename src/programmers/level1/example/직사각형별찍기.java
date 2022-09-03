package programmers.level1.example;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 직사각형별찍기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        //0~a-1까지 sb.append("*")을 실행
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));

    }
}
