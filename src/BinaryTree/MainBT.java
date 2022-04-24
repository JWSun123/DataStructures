package BinaryTree;

import Arrays.Array;

import java.util.Arrays;

public class MainBT {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        BinaryTree<String> treeA = new BinaryTree<String>(a);
//                a
//              /    \
//            b       c
//          /   \       \
//        d      e       f

        for (Node node:treeA.depthFirstValues()){
            System.out.println(node.val);
        }
    }
}
