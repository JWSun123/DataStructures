package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree<T> {

    private Node root;
    int size;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public ArrayList<Node> depthFirstValues() {
        ArrayList<Node> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (stack.size() > 0) {
            Node current = stack.pop();
            result.add(current);
//            System.out.println(current.val);

            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
