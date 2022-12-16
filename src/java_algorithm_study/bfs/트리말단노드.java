package java_algorithm_study.bfs;

import java_algorithm_study.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 트리말단노드 {
    static Node root;
    public static void main(String[] args) {
        트리말단노드 tree = new 트리말단노드();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }

    private int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L=0;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                Node current = queue.poll();
                if(current.lt == null && current.rt == null) return L;
                else if(current.lt != null){
                    queue.offer(current.lt);
                }else if(current.rt != null) {
                    queue.offer(current.rt);
                }
            }
            L++;
        }

        return 0;
    }
}
