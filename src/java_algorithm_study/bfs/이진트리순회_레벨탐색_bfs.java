package java_algorithm_study.bfs;

import java_algorithm_study.Node;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회_레벨탐색_bfs {
    Node root;

    public void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        int level=0;

        queue.offer(root);
        while(!queue.isEmpty()){

            int len = queue.size();
            System.out.print(level + ": ");
            for(int i=0; i<len; i++){
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if(current.lt != null) queue.offer(current.lt);
                if(current.rt != null) queue.offer(current.rt);
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        이진트리순회_레벨탐색_bfs tree = new 이진트리순회_레벨탐색_bfs();

        tree.root=new Node(1);

        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);

        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);

        tree.bfs(tree.root);
    }
}
