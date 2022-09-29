package java_algorithm_study.dfs;

import java_algorithm_study.Node;

/** <부모 기준>
 * 전위 순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식
 * 중위 순회 : 왼쪽 자식 -> 부모 -> 오른쪽 자식
 * 후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모
 */
public class 이진트리순회_dfs {
    Node root;

    public void dfs(Node root){
        if(root==null)
            return;
        else{
            System.out.print(root.data + " "); //전위 순회
            dfs(root.lt);
//            System.out.print(root.data + " "); //중위 순회
            dfs(root.rt);
//            System.out.print(root.data + " "); //후위 순회
        }
    }

    public static void main(String[] args) {
        이진트리순회_dfs tree = new 이진트리순회_dfs();

        tree.root=new Node(1);

        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);

        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);

        tree.dfs(tree.root);
    }
}

