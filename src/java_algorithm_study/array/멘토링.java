package java_algorithm_study.array;

import java.util.Scanner;

public class 멘토링 {

    public int solution(int n, int m, int[][] arr){
        int answer = 0;

        for(int i=1; i<=n; i++){//멘토수
            for(int j=1; j<=n; j++){//멘티수
                int count = 0;
                for(int k=0; k<m; k++){//테스트 수
                    int pi=0; //0등
                    int pj=0; //0등
                    for(int s=0; s<n; s++){ //학생 번호를 찾았을 때 그 학생 번호 넣기.
                        if(arr[k][s]==i){
                            pi=s;
                        }
                        if(arr[k][s]==j){
                            pj=s;
                        }
                    }
                    if(pi<pj){
                        count++;
                    }
                }
                if(count==m){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        멘토링 T = new 멘토링();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }
}
