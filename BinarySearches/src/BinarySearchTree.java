import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    private Node<E> findIOP(Node<E> curr) {
        for (curr = curr.left; curr.right != null; curr = curr.right);
        return curr;
    }
    public void insert(E data) {
        insert(root, data);
    }
    public void remove(E data) {
        remove(root, data);
    }
    public boolean search(E data) {
        return search(data, root);
    }
    private void insert(Node<E> curr, E data){
        Node<E> temp = new Node<E>(data);
        if(curr == null){
            root = temp;
        }
        else{
            if(curr.data.compareTo(data)>0){
                if(curr.left!=null) {
                    insert(curr.left, data);
                }
                curr.left = temp;
            }
            if(curr.data.compareTo(data)<0){
                if(curr.right!=null) {
                    insert(curr.right, data);
                }
                curr.right = temp;
            }
        }
    }
    private Node<E> remove(Node<E> curr, E data){
        if(curr==null){
            return null;
        }
        if(curr.data.compareTo(data) < 0){
            curr.right = remove(curr.right, data);
        }
        else if(curr.data.compareTo(data) > 0){
            curr.left = remove(curr.left, data);
        }
        else{
            if(curr.right == null && curr.left == null){
                return null;
            }
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) return curr.left;
            else{
                Node<E> iop = findIOP(curr);
                E temp = curr.data;
                curr.data = iop.data;
                iop.data = temp;
                curr.left = remove(curr.left, data);
            }
        }
        return curr;
    }
    private boolean search(E data, Node<E> curr){
         if (curr!=null){
            if (data.compareTo(curr.data) == 0) {
                return true;
            }
            if (data.compareTo(curr.data) < 0) {
                return search(data, curr.left);
            }
            if (data.compareTo(curr.data) > 0) {
                return search(data, curr.right);
            }
        }
         return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Stack<Node<E>> stack = new Stack<Node<E>>();
            private void pushToLeft(Node<E> curr) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
            public boolean hasNext() {
                if (stack.isEmpty()) {
                    return false;
                }
                return true;
            }
            @Override
            public E next() {
                Node<E> treeNode = stack.pop();
                Node<E> treeRight = treeNode.right;
                if (treeRight != null) {
                    treeNode = treeRight;
                    while (treeNode != null) {
                        stack.push(treeNode);
                        treeNode = treeNode.left;
                    }
                }
                    return treeNode.data;
                }
            };
    }
    protected Node<E> root;
}