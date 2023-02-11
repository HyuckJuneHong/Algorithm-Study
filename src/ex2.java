import java.math.BigDecimal;
import java.util.*;

class SolutionEx1 {

    /**
     * 내가 알고 있는 것 : 당첨자 수, 구매한 사람 수, 당첨 금액
     * 1) 복권 추첨 : 당첨자 수 >= 구매한 사람 이면 모두 당첨
     * 2) 복권 추첨 : 당첨자 수 <= 구매한 사람이면 무작위 당첨
     *
     * 나 -> 가장 당첨확률 높은 복권 구매할 예정
     * 나 -> 당첨 확률 모두 같으면 당첨 금액이 가장 높은 복권
     * @param lotteries : 각 복권의 당첨자수, 구매한 사람 수, 당첨 금액
     * @return : 내가 살 복권 번호
     */
    public static int solution(int[][] lotteries) {
        int answer = 0;
        Map<Integer, Double> map = new HashMap<>();

        //인덱스와 확률로 Map 생성
        for(int i=0; i<lotteries.length; i++){
            if(lotteries[i][0] >= lotteries[i][1]+1){
                map.put(i+1, 100.0);
                continue;
            }
            double lotto = ((double) lotteries[i][0]/((double) lotteries[i][1]+1.0))*100.0;
            map.put(i+1, lotto);
        }

        //확률로 비교 후 같으면 값으로 분류
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if(!o2.getValue().equals(o1.getValue())){
                if(o2.getValue() - o1.getValue() > 0) return 1;
                else return -1;
            }else
                return lotteries[o2.getKey()-1][2] - lotteries[o1.getKey()-1][2];
        });

        answer = list.get(0).getKey();

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {100,100,500},
                {1000,1000,100}
        };

        System.out.println(solution(arr));
    }
}