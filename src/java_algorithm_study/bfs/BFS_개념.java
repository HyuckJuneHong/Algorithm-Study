package java_algorithm_study.bfs;

import java_algorithm_study.Node;

import java.util.LinkedList;
import java.util.Queue;

/** <Queue 를 사용.>
 * //이진트리 순회 - 너비 우선 탐색
 *     1               부
 *  2  -  3         왼자  오자
 * 4-5   6-7
 *
 * 1. 레벨 탐색 순회 : 1 2 3 4 5 6 7
 */
public class BFS_개념 {
    static Node root;

    public static void main(String[] args) {
        BFS_개념 tree = new BFS_개념();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.bfs(tree.root);
    }

    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            System.out.print(L + " : ");
            for(int i=0; i<len; i++){
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if(current.lt != null) queue.offer(current.lt);
                if(current.rt != null) queue.offer(current.rt);
            }
            L++;
            System.out.println();
        }
    }
}
