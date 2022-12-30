import java.util.*;

class Solution {

    private static List<List<Node>> graph = new ArrayList<>();

    public static class Node{
        int edge;
        int weight;

        public Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    /**
     * @param n : 지점 수
     * @param paths : 경로들
     * @param gates : 출입구 번호들
     * @param summits : 산봉우리 번호들
     * @return
     */
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        //graph create
        for(int[] path : paths){
            int startEdge = path[0];
            int endEdge = path[1];
            int weight = path[2];

            if(gateCheck(startEdge, gates) || summitCheck(endEdge, summits)){
                graph.get(startEdge).add(new Node(endEdge, weight));
            }else if(gateCheck(endEdge, gates) || summitCheck(startEdge, summits)){
                graph.get(endEdge).add(new Node(startEdge, weight));
            }else{
                graph.get(startEdge).add(new Node(endEdge, weight));
                graph.get(endEdge).add(new Node(startEdge, weight));
            }
        }

        //intensity check
        return dp(n, gates, summits);
    }

    private static int[] dp(int n, int[] gates, int[] summits){
        Queue<Node> queue = new LinkedList<>();

        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        for(int gate : gates){
            queue.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            if(currentNode.weight > intensity[currentNode.edge]){
                continue;
            }

            for(int i=0; i<graph.get(currentNode.edge).size(); i++){
                Node nextNode = graph.get(currentNode.edge).get(i);

                int dis = Math.max(intensity[currentNode.edge], nextNode.weight);
                if(intensity[nextNode.edge] > dis){
                    intensity[nextNode.edge] = dis;
                    queue.offer(new Node(nextNode.edge, dis));
                }
            }
        }

        int minWeight = Integer.MAX_VALUE;
        int summitNumber = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for(int summit : summits){
            if(intensity[summit] < minWeight){
                summitNumber = summit;
                minWeight = intensity[summit];
            }
        }

        return new int[]{summitNumber, minWeight};
    }

    private static boolean gateCheck(int edge, int[] gates){
        for(int gate : gates){
            if(edge == gate){
                return true;
            }
        }
        return false;
    }

    private static boolean summitCheck(int edge, int[] summits){
        for(int summit : summits){
            if(edge == summit){
                return true;
            }
        }
        return false;
    }
}
