package programmers.level1.위클리_챌린지;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long amount = 0;              //사용한 금액
        long currentPrices = 0;       //현재 가격

        for(int i=1; i<=count; i++){
            currentPrices += price;
            amount += currentPrices;
        }

        if(amount > money){
            answer = amount-money;
        }

        return answer;
    }
}
