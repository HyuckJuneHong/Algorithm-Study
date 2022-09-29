package java_algorithm_study.dfs;

import java_algorithm_study.Node;

public class Tree_말단노드까지_가장_짧은_경로_dfs {
    Node root;

    public int dfs(int level, Node root){
        //말단 노드
        if(root.lt == null && root.rt == null) return level;
        else{
            return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
        }
    }

    public static void main(String[] args) {
        Tree_말단노드까지_가장_짧은_경로_dfs tree = new Tree_말단노드까지_가장_짧은_경로_dfs();

        tree.root=new Node(1);

        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);

        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);

        System.out.println(tree.dfs(0, tree.root));
    }
}
