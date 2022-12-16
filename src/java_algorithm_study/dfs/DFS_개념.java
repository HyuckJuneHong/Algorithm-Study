package java_algorithm_study.dfs;

import java_algorithm_study.Node;

/**
 * //이진트리 순회 - 깊이 우선 탐색
 *     1               부
 *  2  -  3         왼자  오자
 * 4-5   6-7
 *
 * 1. 전위 순회 : 1 2 4 5 3 6 7    -> 부 - 왼 - 오
 * 2. 중위 순회 : 4 2 5 1 6 3 7    -> 왼 - 부 - 오
 * 3. 후위 순회 : 4 5 2 6 7 3 1    -> 왼 - 오 - 부
 *
 * <전위순회 흐름순서>
 *     1. dfs(1) -> Sout(1)
 *     2. dfs(2) -> Sout(2)
 *     2. dfs(4) -> Sout(4) -> dfs(null) -> return;
 *     3. dfs(5) -> Sout(5) -> dfs(null) -> return;
 *     4. dfs(3) -> Sout(3)
 *     5. dfs(6) -> Sout(6) -> dfs(null) -> return;
 *     6. dfs(7) -> Sout(7) -> dfs(null) -> return;
 * </흐름순서>
 */
public class DFS_개념 {
    static Node root;

    public static void main(String[] args) {
        DFS_개념 tree = new DFS_개념();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.dfs(tree.root);
    }

    private void dfs(Node root) {
        if(root==null) return;

        System.out.print(root.data + " ");  //전위순회
        dfs(root.lt);
//        System.out.print(root.data + " ");  //중위순회
        dfs(root.rt);
//        System.out.print(root.data + " ");  //후위순회
    }
}
