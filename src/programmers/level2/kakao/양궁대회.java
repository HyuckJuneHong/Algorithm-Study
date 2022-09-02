package programmers.level2.kakao;

public class 양궁대회 {

    static int maxDepth;         //최대 깊이
    static int scoreDiffMax = 0; //최대 점수 차이

    static int[] apeach;          //어피치 과녁 정보
    static int[] lion;            //라이언 과녁 정보 (점수 차이 최대)

    public static int[] solution(int n, int[]info){
        maxDepth = n;
        apeach= info;
        int[] firstLion = new int[11];

        dfs(0, firstLion, -1);
        return scoreDiffMax > 0 ? lion : new int[]{-1};
    }
    public static void dfs(int depth, int[] info, int index){

        //최종 점수 체크
        if(depth == maxDepth){
            int apeachScore = 0;
            int lionScore = 0;

            //라이언, 어피치 점수 계산
            for(int i=0; i<11; i++){
                if(info[i] > apeach[i]){
                    lionScore += 10 - i;
                }else if(apeach[i] != 0){
                    apeachScore += 10 - i;
                }
            }

            //같은 경우 -> 가장 낮은 점수부터 맞춘 경우만 교체
            int scoreDiff = lionScore - apeachScore;
            if(scoreDiff > scoreDiffMax){
                scoreDiffMax = scoreDiff;
                lion = info;
            }else if(scoreDiffMax > 0 && scoreDiff == scoreDiffMax){
                for(int i=10; i>=0; i--){
                    if(info[i] > lion[i]){
                        lion = info;
                    }else if(lion[i] > info[i]){
                        return;
                    }
                }
            }
            return;
        }

        for(int i=index+1; i<11; i++){
            int[] newInfo = new int[11];

            for(int j=0; j<11; j++){
                newInfo[j] = info[j];
            }

            //라이언 점수 획득 => 어피치 맞춘 횟수 + 1
            if(i==10){
                newInfo[i] += maxDepth - depth;
                dfs(maxDepth, newInfo, i);
            }else if(maxDepth - depth > apeach[i]){
                newInfo[i] += apeach[i] + 1;
                dfs(depth+apeach[i]+1, newInfo, i);
            }
        }
    }
}
