package java_algorithm_study.dfs_bfs_경로탐색_행렬_리스트;

import java_algorithm_study.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_말단노드까지의_가장_짧은_경로_bfs {
    Node root;
    public int bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                Node current = queue.poll();
                if(current.rt == null && current.lt == null){
                    return level;
                }
                if(current.lt != null) queue.offer(current.lt);
                if(current.rt != null) queue.offer(current.rt);
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Tree_말단노드까지의_가장_짧은_경로_bfs tree = new Tree_말단노드까지의_가장_짧은_경로_bfs();

        tree.root=new Node(1);

        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);

        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);

        System.out.println(tree.bfs(tree.root));
    }
}
