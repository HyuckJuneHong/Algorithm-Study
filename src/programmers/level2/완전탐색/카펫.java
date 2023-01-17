package programmers.level2.완전탐색;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        int[] answer = find(yellow, sum);
        return answer;
    }

    public static int[] find(int yellow, int sum){
        int x=0, y=0;

        for(int i=1; i<=yellow; i++){
            if(yellow%i == 0){
                x = Math.max(i, yellow/i);
                y = Math.min(i, yellow/i);

                if((x+2) * (y+2) == sum){
                    break;
                }
            }
        }

        return new int[]{x+2, y+2};
    }
}
