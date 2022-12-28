package programmers.level3.kakao;

import java.util.*;

public class 등산코스정하기 {
    private static class Node{
        int e;  //edge
        int w;  //weight

        public Node(int e,
                    int w) {
            this.e = e;
            this.w = w;
        }
    }

    private static List<List<Node>> graph;

    /**
     * @param n : 지점수
     * @param paths : 각 등산로 경로들
     * @param gates : 출입구 번호들
     * @param summits : 산봉우리 번호들
     */
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] path : paths){
            int start = path[0];
            int end = path[1];
            int weight = path[2];

            if(isGate(start, gates) || isSummit(end, summits)){
                //게이트일 경우 다른 곳으로만 갈 수있는 단방향
                graph.get(start).add(new Node(end, weight));
            }else if(isGate(end, gates) || isSummit(start, summits)){
                //산봉우리일 경우 특정 한 곳에서 산봉우리로만 올 수 있는 단방향
                graph.get(end).add(new Node(start, weight));
            }else{
                //일반 경로일 경우 양방향
                graph.get(start).add(new Node(end, weight));
                graph.get(end).add(new Node(start, weight));
            }
        }

        return dp(n, gates, summits);
    }

    /**
     * 정상까지 갔을 때 최소 경로일 시 돌아오는 경로도 같게 하면 됨.
     * 즉, 정상까지 가는 경로만 고려.
     * @param n : 지점수
     * @param gates : 게이트 번호들
     * @param summits : 산봉우리 번호들
     * @return
     */
    private static int[] dp(int n, int[] gates, int[] summits) {
        Queue<Node> queue = new LinkedList<>();
        int[] intensity = new int[n + 1];       //최소 시간

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for(int gate : gates){
            queue.offer(new Node(gate, 0));     //게이트 큐에 넣는다.
            intensity[gate] = 0;                    //시작 지점 = 0
        }

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if(currentNode.w > intensity[currentNode.e]) continue;  //현재 가중치가 저장된 가중치보다 클 때 생략

            for(int i=0; i<graph.get(currentNode.e).size(); i++){
                Node nextNode = graph.get(currentNode.e).get(i);

                //최소 갱신
                int min = Math.max(intensity[currentNode.e], nextNode.w);
                if(intensity[nextNode.e] > min){
                    intensity[nextNode.e] = min;
                    queue.offer(new Node(nextNode.e, min));
                }
            }
        }

        int summitNumber = Integer.MAX_VALUE;   //산봉우리 번호
        int minWeight = Integer.MAX_VALUE;      //최솟값

        Arrays.sort(summits);

        for(int summit : summits){
            if(intensity[summit] < minWeight){
                summitNumber = summit;
                minWeight = intensity[summit];
            }
        }

        return new int[]{summitNumber, minWeight};
    }

    /**
     * 게이트 확인
     * @param num 검사할 번호
     * @param gates 게이트 번호들
     * @return 게이트 맞으면 true, 아니면 false
     */
    private static boolean isGate(int num, int[] gates){
        for(int gate : gates){
            if(num == gate)
                return true;
        }
        return false;
    }

    /**
     * 산봉우리 확인
     * @param num 검사할 번호
     * @param summits 산봉우리 번호들
     * @return 산봉우리 맞으면 true, 아니면 false
     */
    private static boolean isSummit(int num, int[] summits){
        for(int summit : summits){
            if(num == summit)
                return true;
        }
        return false;
    }
}
