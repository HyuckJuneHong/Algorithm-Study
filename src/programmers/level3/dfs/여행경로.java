package programmers.level3.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    /**
     * 항상 ICN 출발
     * 주어진 항공권 모두 사용
     * 가능 경로 2개  이상이면 알파벳 순서 반환
     * @param tickets :항공권 정보 [a, b] : a 공항 -> b 공항
     * @return 방문 경로
     */
    public String[] solution(String[][] tickets) {
        int count = 0;

        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, count);

        Collections.sort(list);

        String[] answer = list.get(0).split(" ");

        return answer;
    }

    public void dfs(String start, String next, String[][] tickets, int count){
        if(count == tickets.length){
            list.add(next);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            //출발 공항 = 티켓 출발 공항 && 방문 X
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], next + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}
