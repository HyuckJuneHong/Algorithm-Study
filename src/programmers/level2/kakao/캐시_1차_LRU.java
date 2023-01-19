package programmers.level2.kakao;

public class 캐시_1차_LRU {
    /** 조건 : LRU 사용
     * hit : 1 / miss : 5
     * @param cacheSize : 캐시크기 (0~30)
     * @param cities : 도시 이름 배열 (대소문자 구분 X)
     * @return : 총 실행시간
     */
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return cities.length*5;

        String[] cache = new String[cacheSize];

        for(String city : cities){
            city = city.toUpperCase();
            int index = -1;
            for(int i=0; i<cacheSize; i++){
                if(city.equals(cache[i])) {
                    index=i;
                }
            }

            if(index == -1){
                for(int i=cacheSize-1; i>=1; i--){
                    cache[i] = cache[i-1];
                }
                answer += 5;
            }else{
                for(int i=index; i>=1; i--){
                    cache[i] = cache[i-1];
                }
                answer++;
            }

            cache[0] = city;
        }

        return answer;
    }
}
