package level2;

import java.util.Arrays;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
//        Arrays.fill(answer, 0); 없어도 됨.

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] <= prices[j]){
                    answer[i]++;
                }else{
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
