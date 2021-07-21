import java.util.*;

public class myBinarySearchTree {
        
    private class Node {
         private int val;
         private Node left, right;
         
         public Node(int data) {
             this.val = data;
             this.left = null;
             this.right = null;
         }
    }
    
    Node root;
    
    public myBinarySearchTree() {
        root = null;
    }
    
    public void insert(int key) {
        
        root = insertHelper(root, key);
    }
    
    public Node insertHelper(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        
        if(root.val < key) {
            root.right = insertHelper(root.right, key);
        }
        
        else if(root.val > key) {
            root.left = insertHelper(root.left, key);
        }       
        return root;      
    }
    
    public boolean search(int key) {
        return searchHelper(root, key);
    }
    
    public boolean searchHelper(Node root, int key) {
        if(root == null) {
            return false;
        }
        
        if(root.val == key) {
            return true;
        }       
        return (root.val < key) ? searchHelper(root.left, key) : searchHelper(root.right, key);
    }
    
    public void remove(int key) {
        
        root =  removeHelper(root, key);
    }
    
    public Node removeHelper(Node root, int key) {
        if(root == null) {
            return null;
        }
        
        if(root.val == key) {
            
            // no children
            if(root.left == null & root.right == null) {
                root = null;
                return root;
            }
            
            // one child, set root to that child
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            
            // 2 children
            int minVal = findMinVal(root.right);
            root.val = minVal;
            removeHelper(root.right, minVal);
        }
        if(root.val < key) {
            root.right = removeHelper(root.right, key);
        }
        if(root.val > key) {
            root.left = removeHelper(root.left, key);
        }       
        return root;
    }
    
    private int findMinVal(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    
    public int findMaxDepth() {
        int maxd = findMaxDepthHelper(root);
        return maxd;
    }
    
    public int findMaxDepthHelper(Node root) {
        
        if(root == null) {
            return -1;
        }
        
        int lefth = findMaxDepthHelper(root.left);
        int righth = findMaxDepthHelper(root.right);
        
        return Math.max(lefth, righth) + 1;
    }
    
    public void inOrderTraversal() {
        inOrderHelper(root);
    }
    
    public void inOrderHelper(Node root) {

        if(root != null) {
            inOrderHelper(root.left);
            System.out.print(root.val + " ");
            inOrderHelper(root.right);
        }
    }
    
    public void preOrderTraversal() {
        preOrderHelper(root);
    }
    
    public void preOrderHelper(Node root) {

        if(root != null) {
            System.out.print(root.val + " ");
            preOrderHelper(root.left);
            preOrderHelper(root.right);
        }
    }
    
    public void postOrderTraversal() {
        postOrderHelper(root);
    }
    
    public void postOrderHelper(Node root) {

        if(root != null) {
            postOrderHelper(root.left);
            postOrderHelper(root.right);
            System.out.print(root.val + " ");
        }
    }
    
    public static void main(String[] args) {
        
        myBinarySearchTree tree = new myBinarySearchTree();
        tree.insert(10);
        tree.insert(3);
        tree.insert(12);
        
        tree.preOrderTraversal();
        System.out.println();
        
        tree.inOrderTraversal();
        System.out.println();
        
        tree.postOrderTraversal();
        System.out.println();
        
        tree.remove(3);
        tree.inOrderTraversal();
        System.out.println();
        
        // max depth
        System.out.println(tree.findMaxDepth());

    }
}
