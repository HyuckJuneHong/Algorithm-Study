package java_algorithm_study.dfs;


import java_algorithm_study.Node;

public class 트리말단노드 {
    Node root;

    public static void main(String[] args) {
        트리말단노드 tree = new 트리말단노드();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0, tree.root));
    }

    private int DFS(int i, Node root) {
        if(root.lt == null &&root.rt == null) return i;
        else return Math.min(DFS(i+1, root.lt), DFS(i+1, root.rt));
    }
}


