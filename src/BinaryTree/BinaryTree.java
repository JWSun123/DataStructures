package BinaryTree;

import java.util.*;

public class BinaryTree<T> {

    private Node root;
    int size;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public ArrayList<Node> depthFirstValues() { //use STACK data structure
        ArrayList<Node> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);
        while (stack.size() > 0) {
            Node current = stack.pop();
            result.add(current);
//            System.out.println(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    public ArrayList<T> depthFirstValuesRecursive(Node node, ArrayList<T> result) {
        if (result == null) result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        if (node != null) {
            result.add((T) node.val);

            depthFirstValuesRecursive(node.left, result);
            depthFirstValuesRecursive(node.right, result);

        }
        return result;
    }

    public ArrayList<T> breadthFirstValues() { //use QUEUE data structure
        ArrayList<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            Node node = nodes.remove();
            result.add((T) node.val);

            if (node.left != null){
                nodes.add(node.left);
            }
            if (node.right != null){
                nodes.add(node.right);
            }
        }
        return result;
    }

//    public ArrayList<T> breadthFirstValuesRecursive(Node node, ArrayList<T> result) {
//        if (result == null) result = new ArrayList<>();
//        if (root == null) return null;
//        if (node != null) {
//            breadthFirstValuesRecursive(node.left, result);
//            breadthFirstValuesRecursive(node.right, result);
//            result.add((T) node.val);
//        }
//        return result;
//    }
}
